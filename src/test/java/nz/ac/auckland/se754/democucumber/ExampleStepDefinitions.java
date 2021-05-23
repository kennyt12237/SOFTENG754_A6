package nz.ac.auckland.se754.democucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleStepDefinitions {

    private int num1, num2, result;

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(Integer int1) {
        num1 = int1;
    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(Integer int1) {
        num2 = int1;
    }

    @When("I press add")
    public void i_press_add() {
        result = new Example().add(num1, num2);
    }

    @Then("The result should be {int}")
    public void the_result_should_be(Integer expected) {
        assertEquals(expected, result);
    }

}
