package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	public static Select select;
	public static JavascriptExecutor javaScript;

	//Explicit Wait to Click on WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//Explicit Wait to Send Data to WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//Explicit Wait for Element To Be Visible.
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int explicitWait)
	{
		return new WebDriverWait(driver, explicitWait).
				until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	//To Select a value from Drop Down by using SelectByVisibleText Method.
	public static void selectValueFromDropDownByText(WebElement element, String value) 
	{
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	//To Click on WebElement using JavaScript Executor.
	public static void clickElementByJavaScript(WebElement element, WebDriver driver) 
	{
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].click();", element);
	}

}
