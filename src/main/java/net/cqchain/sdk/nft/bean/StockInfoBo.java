package net.cqchain.sdk.nft.bean;

import lombok.Data;

@Data
public class StockInfoBo {
    // 文件地址
    private String url;

    // 文件哈希
    private String urlHash;

    // 售价（单位分）
    private Long price;

    // 是否可售 1可售 2不可售
    private Integer sellStatus;
}
