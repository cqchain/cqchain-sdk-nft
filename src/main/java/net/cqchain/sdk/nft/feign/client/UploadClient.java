package net.cqchain.sdk.nft.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.form.FormData;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;

public interface UploadClient {
    /**
     * 创建用户
     */
    @RequestLine("POST /upload")
    @Headers("Content-Type: multipart/form-data")
    BaseResponse<String> upload(@Param("file") FormData file);
}
