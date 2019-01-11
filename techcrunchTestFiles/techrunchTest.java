package test;

import Examples.techcrunchClass;
import Examples.techcrunchNewsClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class techrunchTest {
    private final static int NUMBER_OF_EXPECTED_AUTHOR = 20;
    private final static int NUMBER_OF_EXPECTED_ARTICLES = 20;
    private final static int NUMBER_OF_EXPECTED_IMAGES = 20;
    private static techcrunchClass automation;

    @BeforeClass
    public static void setUp() {
        automation = new techcrunchClass();
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void articleNumberVerification() {
        int articleNumbers = automation.getArticleNumbers();
        assertEquals(NUMBER_OF_EXPECTED_ARTICLES, articleNumbers);
    }

    @Test
    public void authorNumbersVerification() {
        int authorNumbers = automation.getAuthorNumbers();
        assertEquals(NUMBER_OF_EXPECTED_AUTHOR, authorNumbers);
    }


    @Test
    public void isAuthorNameEmpty() {
        boolean isEmpty = automation.isAuthorNameEmpty();
        assertEquals(true, isEmpty);
    }

    @Test
    public void comparisonOfAuthorAndArticle() {
        boolean isEqual = automation.compareAuthorAndArticleNumbers();
        assertEquals(true, isEqual);
    }

    @Test
    public void imageNumbersVerification() {
        int imageNumbers = automation.getNumberOfImages();
        assertEquals(NUMBER_OF_EXPECTED_IMAGES, imageNumbers);
    }

    @Test
    public void isImageFieldEmpty() {
        boolean isEmpty = automation.isImageFieldEmpty();
        assertEquals(true, isEmpty);
    }

    @Test
    public void comparisonOfImageAndArticle() {
        boolean isEqual = automation.compareImageAndArticleNumbers();
        assertEquals(true, isEqual);
    }
}

//    @Test
//    public void checkLinks() {
//        boolean isEmpty = automation.isAuthorNameEmpty();
//        assertEquals(true, isEmpty);
//