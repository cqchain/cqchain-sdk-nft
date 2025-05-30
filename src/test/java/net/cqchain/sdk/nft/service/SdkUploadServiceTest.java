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
}
