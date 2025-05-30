package net.cqchain.sdk.nft.feign;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import net.cqchain.sdk.nft.config.SdkConfig;
import net.cqchain.sdk.nft.config.SdkConfigLoader;
import net.cqchain.sdk.nft.feign.client.AuthClient;
import net.cqchain.sdk.nft.feign.entity.AuthDto;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.NonceDto;
import org.fisco.bcos.sdk.v3.crypto.CryptoSuite;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.v3.model.CryptoType;

import java.util.concurrent.TimeUnit;

public class TokenManager {
    private final SdkConfig sdkConfig;

    private final AuthClient authClient;

    private final LoadingCache<String, String> tokenCache;

    public TokenManager() {
        this.sdkConfig = SdkConfigLoader.getSdkConfig();
        this.authClient = ClientFactory.create(AuthClient.class);
        this.tokenCache = Caffeine.newBuilder()
                .expireAfterWrite(55, TimeUnit.MINUTES) // 预留5分钟刷新
                .build(key -> getAuthToken());
    }

    // 懒加载 + 线程安全
    private static class Holder {
        private static final TokenManager INSTANCE = new TokenManager();
    }

    // 全局访问点
    public static TokenManager getInstance() {
        return Holder.INSTANCE;
    }

    private String getNonce() {
        NonceDto dto = new NonceDto();
        dto.setAddress(sdkConfig.getAddress());
        BaseResponse<String> response = authClient.getNonce(dto);
        return response.getData();
    }

    private String getAuthToken() {
        AuthDto dto = new AuthDto();
        dto.setAddress(sdkConfig.getAddress());
        dto.setPubKey(sdkConfig.getPublicKey());

        // nonce
        String nonce = getNonce();
        dto.setNonce(nonce);

        // 签名
        CryptoSuite cryptoSuite = new CryptoSuite(CryptoType.ECDSA_TYPE);
        CryptoKeyPair keyPair = cryptoSuite.getKeyPairFactory().createKeyPair(sdkConfig.getPrivateKey());
        String hash = cryptoSuite.hash(nonce);
        String sign = cryptoSuite.sign(hash, keyPair).convertToString();
        dto.setSignature(sign);

        // 发起请求
        BaseResponse<String> response = authClient.getToken(dto);
        return response.getData();
    }

    public String getToken() {
        return tokenCache.get("token");
    }
}
