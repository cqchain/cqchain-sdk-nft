package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthDto {
    // 账户地址
    @NotBlank
    private String address;

    // 公钥
    @NotBlank
    private String pubKey;

    // 签名
    @NotBlank
    private String signature;

    // 随机值
    @NotBlank
    private String nonce;
}
