package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UrlDto {
    // 发行方地址
    @NotBlank(message = "发行方地址不能为空")
    private String address;

    // 发行方公钥
    @NotBlank(message = "发行方公钥不能为空")
    private String publicKey;

    // 合约地址
    @NotBlank(message = "合约地址不能为空")
    private String contractAddress;

    // 文件地址
    @NotBlank(message = "文件地址不能为空")
    private String url;

    // 文件哈希
    @NotBlank(message = "文件哈希不能为空")
    private String urlHash;

    // 藏品ID
    private Integer tokenId;

    // 签名信息，使用发行方私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, contractAddress, url, urlHash, tokenId
    @NotBlank(message = "签名信息不能为空")
    private String signature;
}
