package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajanhune
 */
public class LettersToNumbersTest {

    public LettersToNumbersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void lettersToNumbersEncryptAndDecryptWorks() {
        String testString = "This string is test, it should work";
        String encrypted = LettersToNumbers.encrypt(testString);

        assertEquals(testString, LettersToNumbers.decrypt(encrypted));

    }

    @Test
    public void encryptionReturnsGivenCharWhenLetterIsUnknown() {

        assertEquals("#", LettersToNumbers.encrypt("#"));
    }

    @Test
    public void decryptionReturnsGivenNumberWhenNubmerIsUnknown() {

        assertEquals("257", LettersToNumbers.decrypt("257"));
    }

    @Test
    public void decryptionErrorReturnsErrorMessage() {

        assertEquals("Malformed message given, try again", LettersToNumbers.decrypt("*1*2**3"));
    }

}
