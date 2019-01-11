package Examples;

import config.SeleniumConfig;
import org.openqa.selenium.*;

import java.util.List;

public class techcrunchClass {
    private SeleniumConfig config;
    private WebDriver driver;
    private String url = "https://techcrunch.com/";
    //techcrunch.com will be loaded in google chrome

    public techcrunchClass() {
        config = new SeleniumConfig();
        driver = config.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //Google Chrome windows will be maximized
    }
    public String getTitle() {
        return this.config.getDriver().getTitle();
    }

    public int getArticleNumbers() {
        try {
            List<WebElement> listOfArticles = driver.findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
            return listOfArticles.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such article");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of articles is stored
    }

    public int getAuthorNumbers() {
        try {
            List<WebElement> listOfAuthors = driver.findElements(By.className("river-byline__authors"));
            return listOfAuthors.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such author");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of authors is stored
    }

    public boolean isAuthorNameEmpty() {
        try {
            List<WebElement> listOfAuthors = driver.findElements(By.className("river-byline__authors"));
            for (WebElement webElement : listOfAuthors) {
                String authorName = webElement.getText();
                if (authorName.equals("")) {
                    return false;
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such author");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You are trying to reach non exist author element");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return true;
        //Checks if author name is empty
    }

    public boolean compareAuthorAndArticleNumbers() {
        int articleNumbers = getArticleNumbers();
        int authorNumbers = getAuthorNumbers();
        if (articleNumbers == authorNumbers) {
            System.out.println("Article and author numbers are equal");
            return true;
        } else {
            System.out.println("Article and author numbers are not equal");
            return false;
        }
        //Compares if article and author numbers are the same
    }

    public int getNumberOfImages() {
        try {
            List<WebElement> listOfImages = driver.findElements(By.xpath("//article/footer[@class='post-block__footer']"));
            List<WebElement> listOfSponsoredImages = driver.findElements(By.className("post-block__label"));
            return listOfImages.size() - listOfSponsoredImages.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such image");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of images is stored
    }

    public boolean isImageFieldEmpty() {
        try {
            List<WebElement> listOfImages = driver.findElements(By.xpath("//article/footer[@class='post-block__footer']"));
            List<WebElement> listOfSponsoredImages = driver.findElements(By.className("post-block__label"));

            for (WebElement webElement : listOfImages) {
                String imageMedia = webElement.getAttribute("href");
                if (imageMedia.equals("")) {
                    return false;
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such image");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You are trying to reach non exist image element");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return true;
    }

    public boolean compareImageAndArticleNumbers() {
        int articleNumbers = getArticleNumbers();
        int imageNumbers = getNumberOfImages();
        if (articleNumbers == imageNumbers) {
            System.out.println("Article and image numbers are equal");
            return true;
        } else {
            System.out.println("Article and image numbers are not equal");
            return false;
        }
        //Compares if article and author numbers are the same
    }
}
