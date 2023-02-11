package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CustomerModuleUserInterface {

    public static final Target NORTHWIND_BUTTON = Target.the("Northwind button").
            located(By.xpath("//*[@id='nav_menu1_2']/li[1]/a/span"));
    public static final Target CUSTOMER_BUTTON = Target.the("customer menu button").
            located(By.xpath("//*[@id='nav_menu1_2_1']/li[1]/a/span"));
    public static final Target NEW_CUSTOMER_BUTTON = Target.the("New customer button").
            located(By.xpath("//*[contains(text(), 'New Customer')]"));

    public static final Target ID_CUSTOMER_FIELD = Target.the("Id customer Field").
            located(By.id("Serenity_Demo_Northwind_CustomerDialog9_CustomerID"));
    public static final Target COMPANY_NAME_CUSTOMER_FIELD = Target.the("Company Name customer Field").
            located(By.id("Serenity_Demo_Northwind_CustomerDialog9_CompanyName"));

    public static final Target SAVE_CUSTOMER_BUTTON = Target.the("Save Customer button").locatedBy("//*[contains(text(), 'Save')]");
    public static final Target SEARCH_CUSTOMER_INPUT = Target.the("Search Customer input").locatedBy("//*[@id='GridDiv']/div[2]/div[1]/input");
    public static final Target FIRST_ID_CUSTOMER_LABEL = Target.the("Id Customer label").locatedBy("(//*[@id='GridDiv']/div[3]/div[5]/div/div/div[1]/a)[1]");
    public static final Target FIRST_COMPANY_NAME_CUSTOMER_LABEL = Target.the("Company name Customer label").locatedBy("(//*[@id='GridDiv']/div[3]/div[5]/div/div/div[2]/a)[1]");
    public static final Target ID_SEARCH_TABLE (String id){
        return Target.the("Id Customer label").locatedBy("//*[@id='GridDiv']/div[3]/div[5]/div/div/div[1]//*[contains(text(), '"+id+"')]");
    }
}
