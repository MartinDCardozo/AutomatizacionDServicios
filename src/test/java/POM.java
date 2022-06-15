import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class POM extends BasePom {

    public POM(WebDriver driver) {
        super(driver);
    }

    By btntrago = By.id("download-button");
    By trago1 = By.xpath("/html/body/div[2]/div/div/div[1]/div/div[1]/a");
    By nombre = By.xpath("//*[@id='nombre']");
    By btnquetrago = By.linkText("¿Qué trago?");
    By txtspace = By.id("textoIngredientes");
    By Botonbuscar = By.id("botonBuscar");
    By segundotrago = By.xpath("//*[@id='card2']/div/div[1]/a/i");
    By ingredientes = By.xpath("//*[@id='h5ing']");
    By ingrediente1 = By.xpath("//*[@id='h5ing']/p[1]");
    By ingrediente2 = By.xpath("//*[@id='h5ing']/p[2]");
    By ingrediente3 = By.xpath("//*[@id='h5ing']/p[3]");
    By ingrediente4 = By.xpath("//*[@id='h5ing']/p[4]");
    By ingrediente5 = By.xpath("//*[@id='h5ing']/p[5]");
    By ingrediente6 = By.xpath("//*[@id='h5ing']/p[6]");
    By ingrediente7 = By.xpath("//*[@id='h5ing']/p[7]");
    By ingrediente8 = By.xpath("//*[@id='h5ing']/p[8]");
    By ingrediente9 = By.xpath("//*[@id='h5ing']/p[9]");


    public void Ex1() throws InterruptedException {
        visit("https://cyf-2020.firebaseapp.com/");
        click(btntrago);
        Thread.sleep(3000);
        click(trago1);
        Thread.sleep(3000);
        String title = gettxt(nombre);
        Response response = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + title);
        String body = response.getBody().asString();
        if (body.contains(title)) {
            System.out.println("si  " + title + "\n" + body);
        } else {
            System.out.println("no " + title);
        }

    }

    public void Ex2() throws InterruptedException {
        visit("https://cyf-2020.firebaseapp.com/");
        click(btnquetrago);
        Thread.sleep(3000);
        type("tequila", txtspace);
        click(Botonbuscar);
        Thread.sleep(3000);
        click(segundotrago);
        List<String> Ingredientes = new ArrayList<>();
        Ingredientes.add(gettxt(ingrediente1).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente2).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente3).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente4).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente5).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente6).replace("1/2 oz", "").trim());
        Ingredientes.add(gettxt(ingrediente7).replace("1-2 dash", "").trim());
        Ingredientes.add(gettxt(ingrediente8).replace("1 wedge", "").trim());
        Ingredientes.add(gettxt(ingrediente9).replace("Garnish with", "").trim());
        Response response = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=3-Mile Long Island Iced Tea");
        String body = response.getBody().asString();
        for(String e:Ingredientes){
            if(body.contains(e)){
                System.out.println("si");
            }else{
                System.out.println("no");
            }
        }
}
}

