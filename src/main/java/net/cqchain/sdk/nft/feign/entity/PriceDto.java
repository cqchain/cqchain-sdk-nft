package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PriceDto {
    // 发行方地址
    @NotBlank(message = "发行方地址不能为空")
    private String address;

    // 发行方公钥
    @NotBlank(message = "发行方公钥不能为空")
    private String publicKey;

    // 合约地址
    @NotBlank(message = "合约地址不能为空")
    private String contractAddress;

    // 售价（单位分）
    @NotNull(message = "售价不能为空")
    @Min(value = 0, message = "售价不能为负数")
    private Long price;

    // 藏品ID
    private Integer tokenId;

    // 签名信息，使用发行方私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, contractAddress, price, tokenId
    @NotBlank(message = "签名信息不能为空")
    private String signature;
}
