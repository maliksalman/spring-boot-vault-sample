package com.smalik.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@Import(EnvironmentVaultConfiguration.class)
@VaultPropertySource("secret/spring-boot-vault-sample")
public class VaultDependantConfig {

    @Bean
    public VaultedSecrets beanWithSecrets(@Value("${key1}") String secret1,
                                          @Value("${key2}") String secret2) {
        return new VaultedSecrets(secret1, secret2);
    }
}
