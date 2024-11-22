package steps;

import functions.BaseMethods;
import functions.LogFunction;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFunctions.samsungPageMethods;
import utilities.DriverManager;
import io.cucumber.java.Before;

public class stepDefinitions {

    private Scenario scenario;
    private AndroidDriver driver;

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public stepDefinitions() {
        this.driver= DriverManager.getDriver();
    }

    @Given("Kullanıcı mobil uygulamaya girer")
    public void uygulamaBaslatildi(){
        try{
            LogFunction.logStepResult(scenario, "Kullanıcı siteye gidiyor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("Kullanıcı {string} bölümüne gelir")
    public void elektronikGelir(String jsonParameterName){
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.click(jsonParameterName);
            LogFunction.logStepResult(scenario, "Kullanıcı elektronik tuşuna basar");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("Kullanıcı {string}'a tıklar")
    public void telefonAksesuarlaraGit(String jsonParameterName) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.click(jsonParameterName);
            LogFunction.logStepResult(scenario, "Kullanıcı telefon ve aksesuarlar kategorisine gider");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @And("Kullancı {string}'a {string} yazar")
    public void aramaKutusunaSamsungYazar(String jsonParameterName,String urun) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.search(jsonParameterName,urun);
            LogFunction.logStepResult(scenario, "Kullanıcı " + urun + " araması yapar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Then("Gelen ürünlerden ilkinin {string} ve {string} alır")
    public void ilkUrunIsimVeFiyat(String productName,String productPrice)
    {
        try{
            samsungPageMethods samsungPage=new samsungPageMethods();
            samsungPage.displayFirstProduct(productName,productPrice);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
