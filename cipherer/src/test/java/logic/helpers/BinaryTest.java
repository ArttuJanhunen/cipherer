/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.helpers;

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
public class BinaryTest {

    public BinaryTest() {
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
    public void convertToBinaryWorks() {
        char[] f = {'f'};
        char[] binaryF = "01100110".toCharArray();

        assertArrayEquals(binaryF, Binary.convertToBinary(f));
    }
    
    @Test
    public void convertToStringWorks(){
        String fish = "fish";
        String binaryFish = "0110011001101001011100110110100000001010";
        
        assertEquals(fish, Binary.convertToString(binaryFish));
    }
}
