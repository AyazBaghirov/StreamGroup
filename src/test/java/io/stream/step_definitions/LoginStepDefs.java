package io.stream.step_definitions;

import io.cucumber.java.en.*;
import io.stream.pages.POM;
import io.stream.utilities.ConfigurationReader;
import io.stream.utilities.Driver;

public class LoginStepDefs {

    POM pom = new POM();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page()  {

        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));

      }
    @Given("user insert credentials as {string}")
    public void user_insert_credentials_as(String role) throws InterruptedException {
        pom.getLoginPage().login(Driver.getDriver(),"advisor");

    }
    @When("user click Login button")
    public void user_click_login_button() {
        pom.getLoginPage().loginButton.click();

    }
    @Then("validate user is on homepage")
    public void validate_user_is_on_homepage() {

    }
}
