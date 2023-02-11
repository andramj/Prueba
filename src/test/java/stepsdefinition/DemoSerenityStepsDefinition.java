package stepsdefinition;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.SearchCustomer;
import questions.SearchNewCustomer;
import tasks.Create;
import tasks.UpdateCustomer;
import userinterface.DemoSerenityUserInterface;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static util.GenerateData.*;

public class DemoSerenityStepsDefinition {
    @Managed(driver="chrome")
    private WebDriver chromeBrowser;
    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("user").can(BrowseTheWeb.with(chromeBrowser));
    }
    @Given("^user credentials are in the page$")
    public void userCredentialsAreInThePage() {
        theActorInTheSpotlight().wasAbleTo(Open.browserOn(new DemoSerenityUserInterface()));
    }

    @When("The user wants register a new customer applying changes before save")
    public void userCreatesANewCustomer() {

        theActorInTheSpotlight().attemptsTo(Create.aCustomer(generateId(),generateCompany()));
    }
    @When("The user wants update a customer applying changes before save")
    public void userUpdateACustomer() {
        theActorInTheSpotlight().attemptsTo(UpdateCustomer.aCustomer());
    }

    @Then("he should see the create customer data on table")
    public void theNumberOfOrdersShouldNotChange() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(SearchNewCustomer.searchCustomer()));
    }

    @Then("he should see the contact name customer data on table")
    public void theNumberOfOrderShouldBe() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(SearchCustomer.searchCustomer()));
    }
}
