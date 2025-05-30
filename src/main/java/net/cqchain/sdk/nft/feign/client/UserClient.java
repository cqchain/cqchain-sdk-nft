package net.cqchain.sdk.nft.feign.client;

import feign.RequestLine;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.UserBusinessDto;
import net.cqchain.sdk.nft.feign.entity.UserDto;
import net.cqchain.sdk.nft.feign.entity.UserVo;

public interface UserClient {
    /**
     * 创建用户
     */
    @RequestLine("POST /user")
    BaseResponse<UserVo> createUser(UserDto dto);

    /**
     * 创建企业用户
     */
    @RequestLine("POST /user/business")
    BaseResponse<UserVo> createBusinessUser(UserBusinessDto dto);
}
