package net.cqchain.sdk.nft.service.impl;

import feign.form.FormData;
import net.cqchain.sdk.nft.config.SdkConfig;
import net.cqchain.sdk.nft.feign.ClientFactory;
import net.cqchain.sdk.nft.feign.client.NftClient;
import net.cqchain.sdk.nft.feign.client.UploadClient;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.ReadFileDto;
import net.cqchain.sdk.nft.service.SdkUploadService;

public class SdkUploadServiceImpl implements SdkUploadService {
    private final UploadClient uploadClient;

    public SdkUploadServiceImpl() {
        this.uploadClient = ClientFactory.create(UploadClient.class);
    }

    public SdkUploadServiceImpl(SdkConfig config) {
        this.uploadClient = ClientFactory.create(UploadClient.class, config);
    }

    @Override
    public String upload(String filename, byte[] content) {
        FormData formData = new FormData("file", filename, content);
        BaseResponse<String> response = uploadClient.upload(formData);
        return response.getData();
    }

    @Override
    public String read(String url) {
        ReadFileDto dto = new ReadFileDto();
        dto.setUrl(url);
        BaseResponse<String> response = uploadClient.read(dto);
        return response.getData();
    }
}
