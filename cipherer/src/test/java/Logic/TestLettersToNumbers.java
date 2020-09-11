package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import logic.LettersToNumbers;
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
public class TestLettersToNumbers {
    
    public TestLettersToNumbers() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testTest() {
        String test1 = "test";
        String test2 = "test";
        assertEquals(test1, test2);
    }
    
    @Test
    public void why() {
        System.out.println("whyyyy");
        assertEquals(true, true);
    }
    
    @Test
    public void encryptAndDecryptWork() {
        String message = "Somehow my tests will not run at all at the moment, no matter what i try...";
        String crypted = LettersToNumbers.encrypt(message);
        assertEquals(message, LettersToNumbers.decrypt(crypted));
    }
}
