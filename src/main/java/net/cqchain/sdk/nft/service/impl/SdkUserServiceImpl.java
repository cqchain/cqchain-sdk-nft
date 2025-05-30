package net.cqchain.sdk.nft.service.impl;

import net.cqchain.sdk.nft.bean.CreateBusinessUserBo;
import net.cqchain.sdk.nft.bean.CreateUserBo;
import net.cqchain.sdk.nft.feign.ClientFactory;
import net.cqchain.sdk.nft.feign.client.UserClient;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.UserBusinessDto;
import net.cqchain.sdk.nft.feign.entity.UserDto;
import net.cqchain.sdk.nft.feign.entity.UserVo;
import net.cqchain.sdk.nft.service.SdkUserService;
import org.springframework.beans.BeanUtils;

public class SdkUserServiceImpl implements SdkUserService {
    private final UserClient userClient;

    public SdkUserServiceImpl() {
        this.userClient = ClientFactory.create(UserClient.class);
    }

    @Override
    public UserVo createUser(CreateUserBo bo) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(bo, dto);
        BaseResponse<UserVo> response = userClient.createUser(dto);
        return response.getData();
    }

    @Override
    public UserVo createBusinessUser(CreateBusinessUserBo bo) {
        UserBusinessDto dto = new UserBusinessDto();
        BeanUtils.copyProperties(bo, dto);
        BaseResponse<UserVo> response = userClient.createBusinessUser(dto);
        return response.getData();
    }
}
