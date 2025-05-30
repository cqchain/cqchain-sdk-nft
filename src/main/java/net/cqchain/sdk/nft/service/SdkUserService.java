package net.cqchain.sdk.nft.service;

import net.cqchain.sdk.nft.bean.CreateBusinessUserBo;
import net.cqchain.sdk.nft.bean.CreateUserBo;
import net.cqchain.sdk.nft.feign.entity.UserVo;

public interface SdkUserService {
    UserVo createUser(CreateUserBo bo);

    UserVo createBusinessUser(CreateBusinessUserBo bo);
}
