package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StockInfoDto {
    // 文件地址
    @NotBlank(message = "文件地址不能为空")
    private String url;

    // 文件哈希
    @NotBlank(message = "文件哈希不能为空")
    private String urlHash;

    // 售价（单位分）
    @NotNull(message = "售价不能为空")
    @Min(value = 0, message = "售价不能为负数")
    private Long price;

    // 是否可售 1可售 2不可售
    @NotNull(message = "是否可售不能为空")
    private Integer sellStatus;
}
