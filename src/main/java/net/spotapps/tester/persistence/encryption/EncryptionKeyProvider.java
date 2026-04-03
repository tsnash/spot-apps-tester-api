package net.spotapps.tester.persistence.encryption;

import java.util.Base64;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptionKeyProvider {

    @Value("${encryption.key}")
    private String encryptionKey;

    @PostConstruct
    public void init() {
        CryptoConverter.setEncryptionKey(Base64.getDecoder().decode(encryptionKey));
    }
}
