package net.cqchain.sdk.nft.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.form.FormData;
import net.cqchain.sdk.nft.feign.entity.BaseResponse;
import net.cqchain.sdk.nft.feign.entity.ReadFileDto;

public interface UploadClient {
    /**
     * 上传文件
     */
    @RequestLine("POST /upload")
    @Headers("Content-Type: multipart/form-data")
    BaseResponse<String> upload(@Param("file") FormData file);

    /**
     * 读取文件
     */
    @RequestLine("POST /upload/read")
    BaseResponse<String> read(ReadFileDto dto);
}
