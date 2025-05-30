package net.cqchain.sdk.nft.feign.entity;

import lombok.Data;

@Data
public class DeployVo {
    // 合约地址
    private String address;

    // 交易哈希
    private String txHash;
}
