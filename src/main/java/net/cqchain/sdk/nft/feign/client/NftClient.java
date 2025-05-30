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
     * 更新价格
     */
    @RequestLine("PUT /nft/price")
    BaseResponse<String> updatePrice(PriceDto dto);

    /**
     * 更新销售状态
     */
    @RequestLine("PUT /nft/status")
    BaseResponse<String> updateStatus(StatusDto dto);

    /**
     * 更新文件地址
     */
    @RequestLine("PUT /nft/url")
    BaseResponse<String> updateUrl(UrlDto dto);

    /**
     * 资产转移
     */
    @RequestLine("POST /nft/transfer")
    BaseResponse<String> transfer(TransferDto dto);
}
