package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStockInfoDto {
    // 发行方地址
    @NotBlank
    private String address;

    // 发行方公钥
    @NotBlank
    private String publicKey;

    // 合约地址
    @NotBlank
    private String contractAddress;

    // 藏品ID
    private Integer tokenId;

    // 文件地址
    @NotBlank
    private String url;

    // 文件哈希
    @NotBlank
    private String urlHash;

    // 售价（单位分）
    @NotNull
    private Long price;

    // 是否可售 1可售 2不可售
    @NotNull
    private Integer sellStatus;

    // 签名信息，使用发行方私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, contractAddress, tokenId, url, urlHash, price, sellStatus
    @NotBlank
    private String signature;
}
