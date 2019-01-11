package Examples;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class techcrunchNewsClass {
    private SeleniumConfig config;
    private WebDriver driver;
    private String url = "https://techcrunch.com";
    //techcrunch.com will be loaded in google chrome

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }

    public techcrunchNewsClass() {
        config = new SeleniumConfig();
        driver = config.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //Google Chrome window will be maximized
    }

    public boolean checkTextAndHeader() {
        driver.findElement(By.cssSelector("div > div > div > article:nth-child(8) > header > h2")).click();
        String title = getTitle();
        String[] parts = title.split("|");
        String first_part = parts[0];
        return first_part.equals(title);
    }

    public boolean checkLinkInNewsContent() {
        driver.findElement(By.cssSelector("div > div > div > article:nth-child(8) > header > h2")).click();
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@class='article-content']/p/*[@href]"));
        for (WebElement webElement : listOfLinks) {
            String href = webElement.getAttribute("href");
            System.out.println(href);
        }
        return true;
    }
}
