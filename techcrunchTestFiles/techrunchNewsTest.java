package test;

import Examples.techcrunchNewsClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class techrunchNewsTest {
    private static techcrunchNewsClass automation;

    @BeforeClass
    public static void setUp() {
        automation = new techcrunchNewsClass();
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void checkTextAndHeader() {
        boolean isEqual = automation.checkTextAndHeader();
        assertEquals(true, isEqual);
    }

    @Test
    public void checkLinkInNewsContent() {
        boolean isEqual = automation.checkLinkInNewsContent();
        assertEquals(true, isEqual);
    }
}
