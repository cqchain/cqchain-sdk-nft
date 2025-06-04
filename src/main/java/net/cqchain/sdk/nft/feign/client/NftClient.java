package net.cqchain.sdk.nft.feign.client;

import feign.RequestLine;
import net.cqchain.sdk.nft.feign.entity.*;

public interface NftClient {
    /**
     * 系列声明
     */
    @RequestLine("POST /nft/deploy")
    BaseResponse<DeployVo> deploy(DeployDto dto);

    /**
     * 更新发行份数
     */
    @RequestLine("PUT /nft/publish-count")
    BaseResponse<String> updatePublishCount(PublishCountDto dto);

    /**
     * 发行藏品
     */
    @RequestLine("POST /nft/publish")
    BaseResponse<String> publish(PublishDto dto);

    /**
     * 创建库存信息
     */
    @RequestLine("POST /nft/stock-info")
    BaseResponse<String> setStockInfo(UpdateStockInfoDto dto);

    /**
     * 更新库存信息
     */
    @RequestLine("PUT /nft/stock-info")
    BaseResponse<String> updateStockInfo(UpdateStockInfoDto dto);

    /**
     * 资产转移
     */
    @RequestLine("POST /nft/transfer")
    BaseResponse<String> transfer(TransferDto dto);
}
