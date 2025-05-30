package net.cqchain.sdk.nft.feign.client;

import feign.RequestLine;
import net.cqchain.sdk.nft.feign.entity.AuthDto;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.NonceDto;

public interface AuthClient {
    /**
     * 生成随机值
     */
    @RequestLine("POST /auth/nonce")
    BaseResponse<String> getNonce(NonceDto dto);

    /**
     * 生成访问Token
     */
    @RequestLine("POST /auth")
    BaseResponse<String> getToken(AuthDto dto);
}
