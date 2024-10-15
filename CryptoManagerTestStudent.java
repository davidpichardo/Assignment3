import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
    CryptoManager cryptoManager;

    @BeforeEach
    public void setUp() throws Exception{
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("JUNIT"));
        assertTrue(CryptoManager.isStringInBounds("_")); //
        assertFalse(CryptoManager.isStringInBounds("hello"));
        assertFalse(CryptoManager.isStringInBounds("{NOT")); 
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("CDEFG", CryptoManager.caesarEncryption("ABCDE", 2)); // Additional cases
       
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("ABCDE", CryptoManager.caesarDecryption("CDEFG", 2)); // Additional cases
        
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("Z^!P", CryptoManager.bellasoEncryption("COOL", "WORD"));
 
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("COOL", CryptoManager.bellasoDecryption("Z^!P", "WORD"));
     
    }

}
