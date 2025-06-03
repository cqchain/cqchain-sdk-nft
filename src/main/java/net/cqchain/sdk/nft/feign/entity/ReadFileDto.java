package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReadFileDto {
    @NotBlank
    private String url;
}
