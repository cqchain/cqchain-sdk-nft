package net.cqchain.sdk.nft.config;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class SdkConfigLoader {
    @Getter
    private static SdkConfig sdkConfig = new SdkConfig();

    private static final String[] CONFIG_FILES = {
            "application.properties",
            "application.yaml",
            "application.yml"
    };

    static {
        loadConfigurations();
    }

    private static void loadConfigurations() {
        for (String configFile : CONFIG_FILES) {
            try (InputStream in = SdkConfigLoader.class.getClassLoader().getResourceAsStream(configFile)) {
                if (in != null) {
                    if (configFile.endsWith(".properties")) {
                        loadFromProperties(in);
                    } else if (configFile.endsWith(".yaml")) {
                        loadFromYaml(in);
                    } else if (configFile.endsWith(".yml")) {
                        loadFromYaml(in);
                    }
                }
            } catch (Exception e) {
                System.err.printf("Failed to load config file %s: %s%n", configFile, e.getMessage());
            }
        }
    }

    private static void loadFromProperties(InputStream in) throws IOException {
        Properties props = new Properties();
        props.load(in);
        sdkConfig.setAddress(props.get("cqchain-sdk-nft.address").toString());
        sdkConfig.setPublicKey(props.get("cqchain-sdk-nft.public-key").toString());
        sdkConfig.setPrivateKey(props.get("cqchain-sdk-nft.private-key").toString());
    }

    private static void loadFromYaml(InputStream in) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(in);
        Object raw = root.get("cqchain-sdk-nft");
        if (raw instanceof Map<?, ?>) {
            @SuppressWarnings("unchecked")
            Map<String, Object> configMap = (Map<String, Object>) root.get("cqchain-sdk-nft");
            sdkConfig.setAddress(configMap.get("address").toString());
            sdkConfig.setPublicKey(configMap.get("public-key").toString());
            sdkConfig.setPrivateKey(configMap.get("private-key").toString());
        }
    }
}
