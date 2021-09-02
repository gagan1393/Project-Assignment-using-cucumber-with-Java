package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

public class PersonDetails {

	private WebDriver driver;

	// 1. By Locators: OR 
	private By applicationType      = By.xpath("//label[normalize-space()='Single']");
	private By dependants           = By.xpath("//select[@title=\"Number of dependants\"]");
	private By propertyToBuy        = By.xpath("//label[@for=\"borrow_type_home\"]");
	private By incomeBeforeTax      = By.xpath("//input[@aria-labelledby=\"q2q1\"]");
	private By otherIncome          = By.xpath("//input[@aria-labelledby=\"q2q2\"]");
	private By livingExpenses       = By.id("expenses");
	private By HomeLoans            = By.id("homeloans");
	private By otherLoansRepayment  = By.id("otherloans");
	private By otherCommitments     = By.xpath("//input[@aria-labelledby=\"q3q4\"]");
	private By creditCardLimits     = By.id("credit");
	private By borrowButton         = By.id("btnBorrowCalculater");
	private By BorrowerEstimate     = By.id("borrowResultTextAmount");
	private By startOverbtn         = By.xpath("//button[contains(text(),'Start over')]");
	private By borrowerError        = By.xpath("//span[contains(@class,'borrow__error__text')]");

	// 2. Constructor of the page class:
	public PersonDetails(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void selectApplicationType() {
		ElementUtil.clickOn(driver, driver.findElement(applicationType), Constants.EXPLICIT_WAIT);
	}
	
	public void selectNumberOfDependants(int value) {
		ElementUtil.selectValueFromDropDownByText(driver.findElement(dependants), String.valueOf(value));
	}
	
	public void selectPropertyYouWouldLikeToBuy() {
		ElementUtil.clickOn(driver, driver.findElement(propertyToBuy), Constants.EXPLICIT_WAIT);
	}

	public void enterYourIncome(int income) {
		ElementUtil.sendKeys(driver, driver.findElement(incomeBeforeTax), Constants.EXPLICIT_WAIT, String.valueOf(income));
	}

	public void enterOtherIncome(int income) {
		ElementUtil.sendKeys(driver, driver.findElement(otherIncome), Constants.EXPLICIT_WAIT, String.valueOf(income));
	}

	public void enterLivingExpenses(int expense) {
		ElementUtil.sendKeys(driver, driver.findElement(livingExpenses), Constants.EXPLICIT_WAIT, String.valueOf(expense));
	}
	
	public void enterHomeLoanRepayment(int Loan) {
		ElementUtil.sendKeys(driver, driver.findElement(HomeLoans), Constants.EXPLICIT_WAIT, String.valueOf(Loan));
	}
	
	public void enterOtherLoansRepayment(int payment) {
		ElementUtil.sendKeys(driver, driver.findElement(otherLoansRepayment), Constants.EXPLICIT_WAIT, String.valueOf(payment));
	}
	
	public void enterOtherCommitments(int payment) {
		ElementUtil.sendKeys(driver, driver.findElement(otherCommitments), Constants.EXPLICIT_WAIT, String.valueOf(payment));
	}
	
	public void enterTotalCreditCardLimit(int limit) {
		ElementUtil.sendKeys(driver, driver.findElement(creditCardLimits), Constants.EXPLICIT_WAIT, String.valueOf(limit));
	}

	public void clickOnWorkouthowmuchIcouldborrow() {
		ElementUtil.clickOn(driver, driver.findElement(borrowButton), Constants.EXPLICIT_WAIT);
	}
	
	public String getEstimateofBorrower() {
		String text = ElementUtil.waitForElementToBeVisible(driver, BorrowerEstimate, Constants.EXPLICIT_WAIT).getText();
		return text;
	}
	
	public String getBorrowerError() {
		String text = ElementUtil.waitForElementToBeVisible(driver, borrowerError, Constants.EXPLICIT_WAIT).getText();
		return text;
	}
	
	public void clickOnStartOverbutton() {
		ElementUtil.clickElementByJavaScript(driver.findElement(startOverbtn), driver);
	}
	
	public String getIncomefield() {
		String text = ElementUtil.waitForElementToBeVisible(driver, livingExpenses, Constants.EXPLICIT_WAIT).getText();
		return text;
	}
}
