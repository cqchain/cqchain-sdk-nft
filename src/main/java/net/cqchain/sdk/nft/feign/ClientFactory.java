package net.cqchain.sdk.nft.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import net.cqchain.sdk.nft.config.SdkConfig;
import net.cqchain.sdk.nft.config.SdkConfigLoader;
import net.cqchain.sdk.nft.feign.client.NftClient;
import net.cqchain.sdk.nft.feign.client.UploadClient;
import net.cqchain.sdk.nft.feign.client.UserClient;

public class ClientFactory {
    public static <T> T create(Class<T> clazz) {
        SdkConfig config = SdkConfigLoader.getSdkConfig();

        if (clazz == UploadClient.class) {
            return Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new MultiEncoder())
                    .decoder(new GsonDecoder())
                    .requestInterceptor(template -> {
                        String token = TokenManager.getInstance().getToken();
                        template.header("Authorization", "Bearer " + token);
                    })
                    .target(clazz, config.getUrl());
        }

        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .requestInterceptor(template -> {
                    template.header("Content-Type", "application/json");
                    if (clazz == NftClient.class || clazz == UserClient.class) {
                        String token = TokenManager.getInstance().getToken();
                        template.header("Authorization", "Bearer " + token);
                    }
                })
                .target(clazz, config.getUrl());
    }
}
