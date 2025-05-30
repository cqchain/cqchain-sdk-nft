package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusDto {
    // 发行方地址
    @NotBlank(message = "发行方地址不能为空")
    private String address;

    // 发行方公钥
    @NotBlank(message = "发行方公钥不能为空")
    private String publicKey;

    // 合约地址
    @NotBlank(message = "合约地址不能为空")
    private String contractAddress;

    // 是否可售 1可售 2不可售
    @NotNull(message = "是否可售不能为空")
    private Integer sellStatus;

    // 藏品ID
    private Integer tokenId;

    // 签名信息，使用发行方私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, contractAddress, sellStatus, tokenId
    @NotBlank(message = "签名信息不能为空")
    private String signature;
}
