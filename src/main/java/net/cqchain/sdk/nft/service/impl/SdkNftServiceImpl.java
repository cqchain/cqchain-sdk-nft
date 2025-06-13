package net.cqchain.sdk.nft.service.impl;

import net.cqchain.sdk.nft.bean.*;
import net.cqchain.sdk.nft.config.SdkConfig;
import net.cqchain.sdk.nft.feign.ClientFactory;
import net.cqchain.sdk.nft.feign.client.NftClient;
import net.cqchain.sdk.nft.feign.entity.*;
import net.cqchain.sdk.nft.service.SdkNftService;
import net.cqchain.sdk.nft.util.JsonUtil;
import org.fisco.bcos.sdk.v3.crypto.CryptoSuite;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.v3.model.CryptoType;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SdkNftServiceImpl implements SdkNftService {
    private static final String[] DEPLOY_FIELDS = new String[]{"address", "publicKey", "name", "symbol", "homogeneous", "publishCount", "stockInfo"};
    private static final String[] PUBLISH_COUNT_FIELDS = new String[]{"address", "publicKey", "contractAddress", "publishCount"};
    private static final String[] PUBLISH_FIELDS = new String[]{"address", "publicKey", "contractAddress", "homogeneous", "publishCount", "stockInfoList"};
    private static final String[] STOCK_INFO_FIELDS = new String[]{"address", "publicKey", "contractAddress", "tokenId", "url", "urlHash", "price", "sellStatus"};
    private static final String[] TRANSFER_FIELDS = new String[]{"address", "publicKey", "toAddress", "contractAddress", "tokenId"};

    private final NftClient nftClient;

    public SdkNftServiceImpl() {
        this.nftClient = ClientFactory.create(NftClient.class);
    }

    public SdkNftServiceImpl(SdkConfig config) {
        this.nftClient = ClientFactory.create(NftClient.class, config);
    }

    @Override
    public DeployVo deploy(DeployBo bo) {
        DeployDto dto = new DeployDto();
        BeanUtils.copyProperties(bo, dto);

        // 拷贝库存信息，如果不为空
        if (bo.getStockInfo() != null) {
            StockInfoDto stockInfoDto = new StockInfoDto();
            BeanUtils.copyProperties(bo.getStockInfo(), stockInfoDto);
            dto.setStockInfo(stockInfoDto);
        }

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, DEPLOY_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);

        BaseResponse<DeployVo> response = nftClient.deploy(dto);
        return response.getData();
    }

    @Override
    public String updatePublishCount(UpdatePublishCountBo bo) {
        PublishCountDto dto = new PublishCountDto();
        BeanUtils.copyProperties(bo, dto);

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, PUBLISH_COUNT_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);

        BaseResponse<String> response = nftClient.updatePublishCount(dto);
        return response.getData();
    }

    @Override
    public String publish(PublishBo bo) {
        PublishDto dto = new PublishDto();
        BeanUtils.copyProperties(bo, dto);

        // 复制stockInfoList
        List<StockInfoDto> stockInfoList = new ArrayList<>();
        for (StockInfoBo stockInfoBo : bo.getStockInfoList()) {
            StockInfoDto stockInfoDto = new StockInfoDto();
            BeanUtils.copyProperties(stockInfoBo, stockInfoDto);
            stockInfoList.add(stockInfoDto);
        }
        dto.setStockInfoList(stockInfoList);

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, PUBLISH_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);

        BaseResponse<String> response = nftClient.publish(dto);
        return response.getData();
    }

    @Override
    public String createStockInfo(CreateStockInfoBo bo) {
        CreateStockInfoDto dto = new CreateStockInfoDto();
        BeanUtils.copyProperties(bo, dto);

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, STOCK_INFO_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);
        BaseResponse<String> response = nftClient.createStockInfo(dto);
        return response.getData();
    }

    @Override
    public String updateStockInfo(UpdateStockInfoBo bo) {
        UpdateStockInfoDto dto = new UpdateStockInfoDto();
        BeanUtils.copyProperties(bo, dto);

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, STOCK_INFO_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);

        BaseResponse<String> response = nftClient.updateStockInfo(dto);
        return response.getData();
    }

    @Override
    public String transfer(TransferBo bo) {
        TransferDto dto = new TransferDto();
        BeanUtils.copyProperties(bo, dto);

        // 进行签名
        String json = JsonUtil.toOrderedJson(bo, TRANSFER_FIELDS);
        String signature = getSignature(bo.getPrivateKey(), json);
        dto.setSignature(signature);

        BaseResponse<String> response = nftClient.transfer(dto);
        return response.getData();
    }

    private String getSignature(String privateKey, String message) {
        CryptoSuite cryptoSuite = new CryptoSuite(CryptoType.ECDSA_TYPE);
        CryptoKeyPair keyPair = cryptoSuite.getKeyPairFactory().createKeyPair(privateKey);
        String hash = cryptoSuite.hash(message);
        return cryptoSuite.sign(hash, keyPair).convertToString();
    }
}
