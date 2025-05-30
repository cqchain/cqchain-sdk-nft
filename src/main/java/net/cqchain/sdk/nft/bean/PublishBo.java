package net.cqchain.sdk.nft.bean;

import lombok.Data;
import net.cqchain.sdk.nft.feign.entity.StockInfoDto;

import java.util.List;

@Data
public class PublishBo {
    // 发行方地址
    private String address;

    // 发行方公钥
    private String publicKey;

    // 发行方私钥
    private String privateKey;

    // 合约地址
    private String contractAddress;

    // 是否同质化 0否 1是
    // 如果homogeneous=1，则stockInfoList只能传一个元素
    private Integer homogeneous;

    // 发行份数
    private Integer publishCount;

    // 库存信息
    private List<StockInfoBo> stockInfoList;
}
