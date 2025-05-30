package net.cqchain.sdk.nft.feign;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import net.cqchain.sdk.nft.feign.client.NftClient;
import net.cqchain.sdk.nft.feign.client.UploadClient;
import net.cqchain.sdk.nft.feign.client.UserClient;

public class ClientFactory {
    public static <T> T create(Class<T> clazz) {
        if (clazz == UploadClient.class) {
            return Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new FormEncoder())
                    .decoder(new GsonDecoder())
                    .requestInterceptor(template -> {
                        String token = TokenManager.getInstance().getToken();
                        template.header("Authorization", "Bearer " + token);
                    })
                    .target(clazz, ClientConstants.URL);
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
                .target(clazz, ClientConstants.URL);
    }
}
