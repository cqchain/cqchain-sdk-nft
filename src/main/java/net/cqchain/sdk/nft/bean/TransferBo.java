package net.cqchain.sdk.nft.bean;

import lombok.Data;

@Data
public class TransferBo {
    // 持有人地址
    private String address;

    // 持有人公钥
    private String publicKey;

    // 持有人私钥
    private String privateKey;

    // 接收人地址
    private String toAddress;

    // 合约地址
    private String contractAddress;

    // 藏品ID
    private Integer tokenId;
}
