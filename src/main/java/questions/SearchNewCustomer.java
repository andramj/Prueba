package questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.CustomerModuleUserInterface;


public class SearchNewCustomer implements Question<Boolean> {

    public static SearchNewCustomer searchCustomer() {
        return new SearchNewCustomer();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String id = Serenity.sessionVariableCalled("id").toString();
        actor.attemptsTo(Enter.theValue(id).into(CustomerModuleUserInterface.SEARCH_CUSTOMER_INPUT),
                WaitUntil.the(CustomerModuleUserInterface.ID_SEARCH_TABLE(id),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
        return Text.of(CustomerModuleUserInterface.FIRST_ID_CUSTOMER_LABEL).viewedBy(actor).asString().equals(id);

    }
}
