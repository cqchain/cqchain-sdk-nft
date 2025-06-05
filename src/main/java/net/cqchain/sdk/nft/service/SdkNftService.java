package net.cqchain.sdk.nft.service;

import net.cqchain.sdk.nft.bean.*;
import net.cqchain.sdk.nft.feign.entity.DeployVo;

public interface SdkNftService {
    DeployVo deploy(DeployBo bo);

    String updatePublishCount(UpdatePublishCountBo bo);

    String publish(PublishBo bo);

    String createStockInfo(CreateStockInfoBo bo);

    String updateStockInfo(UpdateStockInfoBo bo);

    String transfer(TransferBo bo);
}
