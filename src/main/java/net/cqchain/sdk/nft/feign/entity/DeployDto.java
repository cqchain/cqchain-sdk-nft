package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeployDto {
    // 发行方地址
    @NotBlank(message = "发行方地址不能为空")
    private String address;

    // 发行方公钥
    @NotBlank(message = "发行方公钥不能为空")
    private String publicKey;

    // 签名信息，使用发行方私钥privateKey进行签名，签名对象按以下字段顺序序列化为JSON字符串：
    // address, publicKey, name, symbol, homogeneous, publishCount, stockInfo
    @NotBlank(message = "签名信息不能为空")
    private String signature;

    // 系列名称
    @NotBlank(message = "系列名称不能为空")
    private String name;

    // 系列简称
    @NotBlank(message = "系列简称不能为空")
    private String symbol;

    // 是否同质化 0否 1是
    // 如果homogeneous=0，则不必传递stockInfo字段
    @NotNull(message = "是否同质化不能为空")
    @Min(value = 0, message = "是否同质化值为0或1")
    @Max(value = 1, message = "是否同质化值为0或1")
    private Integer homogeneous;

    // 发行份数
    @NotNull(message = "发行份数不能为空")
    @Min(value = 0, message = "发行份数不能为负数")
    @Max(value = 10000, message = "发行份数不能超过10000份")
    private Integer publishCount;

    // 库存信息
    @Valid
    private StockInfoDto stockInfo;
}
