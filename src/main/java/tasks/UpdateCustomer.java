package tasks;


import util.GenerateData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import static userinterface.CustomerModuleUserInterface.*;
import static userinterface.DemoSerenityUserInterface.SIGN_IN_BUTTON;
import static userinterface.DemoSerenityUserInterface.STARTSHARP_BUTTON;

public class UpdateCustomer implements Task {


    UpdateCustomer(){
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SIGN_IN_BUTTON),
                Click.on(STARTSHARP_BUTTON),
                Click.on(NORTHWIND_BUTTON),
                Click.on(CUSTOMER_BUTTON));
        String id= Text.of(FIRST_ID_CUSTOMER_LABEL).viewedBy(actor).resolve().toString();
        String companyName = GenerateData.generateCompany();
        Serenity.setSessionVariable("id").to(id);
        Serenity.setSessionVariable("company").to(companyName);
        actor.attemptsTo(Click.on(FIRST_ID_CUSTOMER_LABEL),
                Enter.theValue(companyName).into(COMPANY_NAME_CUSTOMER_FIELD),
                Click.on(SAVE_CUSTOMER_BUTTON));
    }
    public static UpdateCustomer aCustomer() {
        return Tasks.instrumented(UpdateCustomer.class);
    }
}
