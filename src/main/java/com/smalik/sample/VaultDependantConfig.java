package com.smalik.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaultDependantConfig {

    @Bean
    public VaultedSecrets beanWithSecrets(@Value("${my.key1}") String secret1,
                                          @Value("${my.key2}") String secret2) {
        return new VaultedSecrets(secret1, secret2);
    }
}
