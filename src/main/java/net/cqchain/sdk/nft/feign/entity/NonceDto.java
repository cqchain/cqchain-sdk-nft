package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NonceDto {
    // 账户地址
    @NotBlank
    private String address;
}
