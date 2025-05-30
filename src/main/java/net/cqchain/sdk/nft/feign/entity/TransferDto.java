package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferDto {
    // 持有人地址
    @NotBlank(message = "持有人地址不能为空")
    private String address;

    // 持有人公钥
    @NotBlank(message = "持有人公钥不能为空")
    private String publicKey;

    // 接收人地址
    @NotBlank(message = "接收人地址不能为空")
    private String toAddress;

    // 合约地址
    @NotBlank(message = "合约地址不能为空")
    private String contractAddress;

    // 藏品ID
    @NotNull(message = "藏品ID不能为空")
    private Integer tokenId;

    // 签名信息，使用持有人私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, toAddress, contractAddress, tokenId
    @NotBlank(message = "签名信息不能为空")
    private String signature;
}
