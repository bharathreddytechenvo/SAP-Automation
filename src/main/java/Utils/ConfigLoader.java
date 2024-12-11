package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConfigLoader {
    public static String browser;
    public static String url;
    public static int timeout;

    public static void loadConfigFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = objectMapper.readValue(new File("src/main/resources/config.json"), Config.class);
        browser = config.getBrowser();
        url = config.getUrl();
        timeout = config.getTimeout();
    }

    public static void loadConfigFromYaml() throws IOException {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader("src/main/resources/config.yaml")) {
            Config config = yaml.loadAs(reader, Config.class);  // Use FileReader instead of File
            browser = config.getBrowser();
            url = config.getUrl();
            timeout = config.getTimeout();
        }
    }

    public static class Config {
        private String browser;
        private String url;
        private int timeout;

        public String getBrowser() {
            return browser;
        }

        public String getUrl() {
            return url;
        }

        public int getTimeout() {
            return timeout;
        }
    }
}
