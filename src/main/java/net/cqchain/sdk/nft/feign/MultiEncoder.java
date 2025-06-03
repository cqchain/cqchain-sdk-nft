package net.cqchain.sdk.nft.feign;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.gson.GsonEncoder;

import java.lang.reflect.Type;
import java.util.Set;

public class MultiEncoder implements Encoder {
    private final Encoder jsonEncoder = new GsonEncoder();
    private final Encoder formEncoder = new FormEncoder(jsonEncoder); // 支持嵌套对象

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        // 判断 Content-Type 决定使用哪个 Encoder
        String contentType = template.headers().getOrDefault("Content-Type", Set.of()).stream().findFirst().orElse("");

        if (contentType.contains("multipart/form-data")) {
            formEncoder.encode(object, bodyType, template);
        } else {
            // 默认使用 JSON
            jsonEncoder.encode(object, bodyType, template);
            // 防止用户忘了手动设置 content-type
            if (!template.headers().containsKey("Content-Type")) {
                template.header("Content-Type", "application/json");
            }
        }
    }
}
