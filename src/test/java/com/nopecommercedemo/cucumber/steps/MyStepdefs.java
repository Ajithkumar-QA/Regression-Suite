package com.nopecommercedemo.cucumber.steps;

import com.nopecommercedemo.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("User is on Home page")
    public void userIsOnHomePage() {

    }

    @When("User click on computer")
    public void userClickOnComputer() {
        new HomePage().clickOnComputer();
    }
}
