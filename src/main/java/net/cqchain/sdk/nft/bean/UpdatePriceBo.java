package net.cqchain.sdk.nft.bean;

import lombok.Data;

@Data
public class UpdatePriceBo {
    // 发行方地址
    private String address;

    // 发行方公钥
    private String publicKey;

    // 发行方私钥
    private String privateKey;

    // 合约地址
    private String contractAddress;

    // 售价（单位分）
    private Long price;

    // 藏品ID
    private Integer tokenId;
}
