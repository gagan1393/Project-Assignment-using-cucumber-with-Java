package stepdefinitions;

import org.junit.Assert;

import com.pages.PersonDetails;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonDetailsSteps {
	
	private PersonDetails persondetails = new PersonDetails(DriverFactory.getDriver());
	
	@Given("user is on calculators and tools page")
	public void user_is_on_calculators_and_tools_page() {
		DriverFactory.getDriver().get(Constants.BASEURL);
		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		System.out.println("The Cuurent URL is : " + currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.BASEURL));
	}

	@When("user choose the Application type details as {string}")
	public void user_choose_the_application_type_details_as(String appliactiontype) {
	    System.out.println("The User choose the Application Type Details as :" + appliactiontype);
	    persondetails.selectApplicationType();
	}

	@When("user enters Number of dependants {int}")
	public void user_enters_number_of_dependants(Integer Dependents) {
		System.out.println("The User choose the Dependents as :" + Dependents);
		persondetails.selectNumberOfDependants(Dependents);
	}

	@When("user choose property to buy as {string}")
	public void user_choose_property_to_buy_as(String propertybuy) {
		System.out.println("The User Select the Property he would like to buy as :" + propertybuy);
		persondetails.selectPropertyYouWouldLikeToBuy();
	}

	@When("user enters income before tax as {int}")
	public void user_enters_income_before_tax_as(Integer income) {
		persondetails.enterYourIncome(income);
	}

	@When("user enters income after tax as {int}")
	public void user_enters_income_after_tax_as(Integer income) {
		persondetails.enterOtherIncome(income);
	}

	@When("user enters living expense of {int}")
	public void user_enters_living_expense_of(Integer expense) {
		persondetails.enterLivingExpenses(expense);
	}

	@When("user enters current home loan payement {int}")
	public void user_enters_current_home_loan_payement(Integer Loan) {
		persondetails.enterHomeLoanRepayment(Loan);
	}

	@When("user enters other loan repayment of {int}")
	public void user_enters_other_loan_repayment_of(Integer payment) {
		persondetails.enterOtherLoansRepayment(payment);
	}

	@When("user enters other commitments of {int}")
	public void user_enters_other_commitments_of(Integer payment) {
		persondetails.enterOtherCommitments(payment);
	}

	@When("user enters total credit card limits of {int}")
	public void user_enters_total_credit_card_limits_of(Integer limit) {
		persondetails.enterTotalCreditCardLimit(limit);
	}

	@Then("user click on how much i could borrow button")
	public void user_click_on_how_much_i_could_borrow_button() {
		persondetails.clickOnWorkouthowmuchIcouldborrow();
	}

	@Then("user should get the result {string}")
	public void user_should_get_the_result(String EXPECTEDRESULT) throws InterruptedException {
		Thread.sleep(5000);
		String ACTUALBORROWERESTIMATE = persondetails.getEstimateofBorrower();
		System.out.println("The Estimate Borrowser is getting is :" + ACTUALBORROWERESTIMATE);
		Assert.assertTrue(ACTUALBORROWERESTIMATE.contains(EXPECTEDRESULT));
	}
	
	@When("user click on start over button after filling the form")
	public void user_click_on_start_over_button_after_filling_the_form() throws InterruptedException {
		Thread.sleep(3000);
		persondetails.clickOnStartOverbutton();
	}

	@Then("the field should be clear and show Empty {string}")
	public void the_field_should_be_clear_and_show_Empty(String EXPECTEDVALUE) throws InterruptedException {
		Thread.sleep(3000);
		String incomefield = persondetails.getIncomefield();
		System.out.println("The field values is :" + incomefield);
		Assert.assertTrue(incomefield.contains(EXPECTEDVALUE));
	}
	
	@And("user should see this Error {string}")
	public void user_should_see_this_Error(String EXPECTEDRESULT) throws InterruptedException {
		Thread.sleep(3000);
		String ACTUALBORROWERESTIMATE = persondetails.getBorrowerError();
		System.out.println("The Error showing is :" + ACTUALBORROWERESTIMATE);
		Assert.assertTrue(ACTUALBORROWERESTIMATE.contains(EXPECTEDRESULT));
	}

}
