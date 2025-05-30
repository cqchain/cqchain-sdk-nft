package net.cqchain.sdk.nft.config;

import lombok.Data;

@Data
public class SdkConfig {
    /**
     * 平台地址
     */
    private String address;

    /**
     * 平台公钥（用于验签）
     */
    private String publicKey;

    /**
     * 平台私钥（用于加签）
     */
    private String privateKey;
}
