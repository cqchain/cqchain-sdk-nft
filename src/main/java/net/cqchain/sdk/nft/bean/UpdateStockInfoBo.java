package net.cqchain.sdk.nft.bean;

import lombok.Data;

@Data
public class UpdateStockInfoBo {
    // 发行方地址
    private String address;

    // 发行方公钥
    private String publicKey;

    // 发行方私钥
    private String privateKey;

    // 合约地址
    private String contractAddress;

    // 藏品ID
    private Integer tokenId;

    // 文件地址
    private String url;

    // 文件哈希
    private String urlHash;

    // 售价（单位分）
    private Long price;

    // 是否可售 1可售 2不可售
    private Integer sellStatus;
}
