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
public class SplitterTest {

    public SplitterTest() {
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
    public void splitReturnsCorrectSplit() {
        String test = "Hello world!";
        String[] split1 = Splitter.split(test, ' ');
        String[] split2 = Splitter.split(test, 'w');
        String[] split3 = Splitter.split(test, '!');

        assertEquals("Hello", split1[0]);
        assertEquals("world!", split1[1]);
        assertEquals("Hello ", split2[0]);
        assertEquals("orld!", split2[1]);
        assertEquals("Hello world", split3[0]);
        assertEquals("", split3[1]);

    }
}
