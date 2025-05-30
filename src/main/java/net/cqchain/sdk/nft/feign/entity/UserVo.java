package net.cqchain.sdk.nft.feign.entity;

import lombok.Data;

@Data
public class UserVo {
    // 用户编号
    private Long userId;

    // 用户名
    private String username;

    // 地址
    private String address;

    // 公钥
    private String publicKey;

    // 私钥，base64加密，前端可用base64解密
    private String privateKey;

    // 助记词
    private String mnemonic;

    // 用户描述
    private String description;

    // 用户类型（1-个人用户 2-企业用户）
    private Integer userType;

    // 创建时间
    private String createTime;

    // 更新时间
    private String updateTime;
}
