package net.spotapps.tester.persistence.encryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

public class CryptoConverterTest {

    private CryptoConverter cryptoConverter;

    @BeforeEach
    public void setUp() {
        cryptoConverter = new CryptoConverter();
        CryptoConverter.setEncryptionKey(Base64.getDecoder().decode("P57DYej7WZOi3KlAKY1uD0ao2BE1Ovaw8cvPmzbGEBA="));
    }

    @Test
    public void testConvertToDatabaseColumn() {
        String plainText = "test";
        String encrypted = cryptoConverter.convertToDatabaseColumn(plainText);
        assertNotEquals(plainText, encrypted);
    }

    @Test
    public void testEncryptDecrypt() {
        String plainText = "test";
        String encrypted = cryptoConverter.convertToDatabaseColumn(plainText);
        String decrypted = cryptoConverter.convertToEntityAttribute(encrypted);
        assertEquals(plainText, decrypted);
    }

    @Test
    public void testEncryptIsNonDeterministic() {
        String plainText = "test";
        String encrypted1 = cryptoConverter.convertToDatabaseColumn(plainText);
        String encrypted2 = cryptoConverter.convertToDatabaseColumn(plainText);
        assertNotEquals(encrypted1, encrypted2);
    }

    @Test
    public void testNullInput() {
        assertNull(cryptoConverter.convertToDatabaseColumn(null));
        assertNull(cryptoConverter.convertToEntityAttribute(null));
    }

    @Test
    public void testInvalidKey() {
        CryptoConverter.setEncryptionKey("invalid-key".getBytes());
        assertThrows(IllegalArgumentException.class, () -> cryptoConverter.convertToDatabaseColumn("test"));
        assertThrows(IllegalArgumentException.class, () -> cryptoConverter.convertToEntityAttribute("test"));
    }
}
