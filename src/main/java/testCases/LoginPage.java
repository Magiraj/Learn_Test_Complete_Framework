package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import common.BaseClass;
import io.qameta.allure.Description;

public class LoginPage extends BaseClass {

	@Description("Login page cheking")
	@Test(dataProvider = "Fname")
	public void LoginMain(String user, String pass) throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.findElement(By.id("username")).sendKeys(user);
			screenStep("Enter user name Successfully", "pass");
		} catch (Exception e) {
			screenStep("Enter user name not Successfully", "fail");
		}
		try {
			driver.findElement(By.id("password")).sendKeys(pass);
			screenStep("Enter password Successfully", "pass");
		} catch (Exception e) {
			screenStep("Enter password not Successfully", "fail");
		}
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			screenStep("Submit Successfully", "pass");
		} catch (Exception e) {
			screenStep("Submit not Successfully", "fail");
		}

	}
	
}
