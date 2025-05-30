package net.cqchain.sdk.nft.service;

import net.cqchain.sdk.nft.bean.CreateBusinessUserBo;
import net.cqchain.sdk.nft.bean.CreateUserBo;
import net.cqchain.sdk.nft.feign.entity.UserVo;
import net.cqchain.sdk.nft.service.impl.SdkUserServiceImpl;
import org.junit.jupiter.api.Test;

class SdkUserServiceTest {
    private final SdkUserService sdkNftService;

    public SdkUserServiceTest() {
        this.sdkNftService = new SdkUserServiceImpl();
    }

    @Test
    public void createUser() {
        CreateUserBo bo = new CreateUserBo();
        bo.setUsername("test9527");
        bo.setDescription("测试用户");
        bo.setPersonName("测试员");
        bo.setIdcard("");
        bo.setCardType(1);
        UserVo vo = sdkNftService.createUser(bo);
        System.out.println(vo);
    }

    @Test
    public void createBusinessUser() {
        CreateBusinessUserBo bo = new CreateBusinessUserBo();
        bo.setUsername("cqonetest9527");
        bo.setUserDesc("测试账户");
        bo.setEpName("新疆春秋文创科技股份有限公司");
        bo.setLogo("https://cqchain-1312577323.cos.ap-chengdu.myqcloud.com/upload/20250526/57fa1c5d21654f4da691c0ff50bb2f92.jpeg");
        bo.setDescription("始导分场般工圆系近车件品或音");
        bo.setEmail("b.qwseke@qq.com");
        bo.setCreditCode("91650104MA79KJ4203");
        bo.setBusiLicenseUrl("https://cqchain-1312577323.cos.ap-chengdu.myqcloud.com/upload/20250526/57fa1c5d21654f4da691c0ff50bb2f92.jpeg");
        bo.setRepresentativeName("艾窝窝");
        bo.setContact("我爱爱");
        bo.setMobile("18625863845");
        bo.setIdcard("");
        bo.setCardType(1);
        bo.setOfficialLetterUrl("https://cqchain-1312577323.cos.ap-chengdu.myqcloud.com/upload/20250526/57fa1c5d21654f4da691c0ff50bb2f92.jpeg");
        UserVo vo = sdkNftService.createBusinessUser(bo);
        System.out.println(vo);
    }
}
