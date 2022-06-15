import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class APITesting {

    private WebDriver driver;
    POM pom;
    @BeforeMethod
    public void setup(){
        pom = new POM(driver);
        driver =pom.ChromeConnection();
    }


    @Test
    public void test1() throws InterruptedException {
        Response response = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=3-Mile Long Island Iced Tea");
        String body = response.getBody().asString();
        System.out.println(body);
    }
    @Test
    public void test2() throws InterruptedException {
        pom.Ex2();
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
     

}