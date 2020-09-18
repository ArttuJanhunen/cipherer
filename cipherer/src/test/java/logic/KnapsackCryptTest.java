/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

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
public class KnapsackCryptTest {

    public KnapsackCryptTest() {
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
    public void knapsackShouldEncryptCorrectly() {
        String test = "fish";
        String encrypted = KnapsackCrypt.encrypt(test);

        assertEquals("1366 1157 1263 921", encrypted);
    }

    @Test
    public void knapsackShouldDecryptCorrectly() {
        String encrypted = "1366 1157 1263 921";

        assertEquals("fish", KnapsackCrypt.decrypt(encrypted));
    }

    @Test
    public void knapsackShouldEncryptAndDecryptCorrectly() {
        String test = "This is a sentence that should work. Right?";
        String encrypted = KnapsackCrypt.encrypt(test);

        assertEquals(test, KnapsackCrypt.decrypt(encrypted));
    }

    @Test
    public void sliceToStringWorks() {
        int[] slice = {1, 2, 3, 4, 5, 6, 7};
        String sliceTotal = KnapsackCrypt.sliceToString(slice);

        assertEquals("28", sliceTotal);
    }

}
