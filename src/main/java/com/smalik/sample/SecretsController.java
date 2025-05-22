package com.smalik.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretsController {

    private final VaultedSecrets secrets;

    public SecretsController(VaultedSecrets secrets) {
        this.secrets = secrets;
    }

    @GetMapping("/")
    public VaultedSecrets getSecrets() {
        return secrets;
    }
}
