package com.Xunbao2026.Xunbao2026.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    static {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
        
        // Load all .env variables into system properties
        String[] keys = {"DB_PASSWORD"};
        for (String key : keys) {
            String value = dotenv.get(key);
            if (value != null && System.getProperty(key) == null) {
                System.setProperty(key, value);
            }
        }
    }
}
