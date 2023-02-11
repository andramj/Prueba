package tasks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static userinterface.CustomerModuleUserInterface.*;

import static userinterface.DemoSerenityUserInterface.*;

public class Create implements Task {

    private String id;
    private String companyName;

    Create(String id, String companyName){
        this.id=id;
        this.companyName=companyName;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SIGN_IN_BUTTON),
                Click.on(STARTSHARP_BUTTON),
                Click.on(NORTHWIND_BUTTON),
                Click.on(CUSTOMER_BUTTON),
                Click.on(NEW_CUSTOMER_BUTTON));
        Serenity.setSessionVariable("id").to(id);
        Serenity.setSessionVariable("companyName").to(companyName);
        actor.attemptsTo(Enter.theValue(id).into(ID_CUSTOMER_FIELD),
                Enter.theValue(companyName).into(COMPANY_NAME_CUSTOMER_FIELD),
                Click.on(SAVE_CUSTOMER_BUTTON));


    }
    public static Create aCustomer(String id, String companyName) {
        return Tasks.instrumented(Create.class,id,companyName);
    }
}
