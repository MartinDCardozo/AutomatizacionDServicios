import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePom {
    private WebDriver driver;

    public BasePom(WebDriver driver){this.driver=driver;}
    public WebDriver ChromeConnection(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tinch\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public void visit(String url){
        driver.get(url);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public String gettxt(By locator){
        return driver.findElement(locator).getText();
    }
    public void type(String inputText,By locator){driver.findElement(locator).sendKeys(inputText);}
    public String getTexts(By locator){return driver.findElement(locator).getAttribute("<p>");}


}
