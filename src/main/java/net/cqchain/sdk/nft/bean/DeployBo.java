package net.cqchain.sdk.nft.bean;

import lombok.Data;

@Data
public class DeployBo {
    // 发行方地址
    private String address;

    // 发行方公钥
    private String publicKey;

    // 发行方私钥
    private String privateKey;

    // 系列名称
    private String name;

    // 系列简称
    private String symbol;

    // 是否同质化 0否 1是
    // 如果homogeneous=0，则不必传递stockInfo字段
    private Integer homogeneous;

    // 发行份数
    private Integer publishCount;

    // 库存信息
    private StockInfoBo stockInfo;
}
