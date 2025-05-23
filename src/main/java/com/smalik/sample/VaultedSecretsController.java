package com.smalik.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultedSecretsController {

    private final VaultedSecrets secrets;

    public VaultedSecretsController(VaultedSecrets secrets) {
        this.secrets = secrets;
    }

    @GetMapping("/")
    public VaultedSecrets getSecrets() {
        return secrets;
    }
}
