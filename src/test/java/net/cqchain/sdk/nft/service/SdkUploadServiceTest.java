package net.cqchain.sdk.nft.service;

import net.cqchain.sdk.nft.service.impl.SdkUploadServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SdkUploadServiceTest {
    private final SdkUploadService sdkUploadService;

    public SdkUploadServiceTest() {
        this.sdkUploadService = new SdkUploadServiceImpl();
    }

    @Test
    void testUpload() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, "Hello, temp file!".getBytes());
        byte[] content = Files.readAllBytes(tempFile);
        String res = sdkUploadService.upload(tempFile.getFileName().toString(), content);
        System.out.println(res);
    }

    @Test
    void testRead() {
        String url = "https://cqchain-1312577323.cos.ap-chengdu.myqcloud.com/upload/20250526/57fa1c5d21654f4da691c0ff50bb2f92.jpeg";
        String res = sdkUploadService.read(url);
        System.out.println(res);
    }
}
