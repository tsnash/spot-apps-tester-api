package net.spotapps.tester.persistence.encryption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.Base64;

@Component
public class EncryptionKeyProvider {

    @Value("${encryption.key}")
    private String encryptionKey;

    @PostConstruct
    public void init() {
        CryptoConverter.setEncryptionKey(Base64.getDecoder().decode(encryptionKey));
    }
}
