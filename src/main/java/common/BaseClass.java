package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;

import utils.DataExcelProvider;

public class BaseClass {
	
public ChromeDriver driver;

@Parameters({"url"})
@BeforeMethod
	public void startApp(String urlValue) {
		 driver  = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(urlValue);

	}
@DataProvider(name="Fname")
public String[][] valueProvider() throws IOException {
	DataExcelProvider datav=new DataExcelProvider();
	String[][] dataC = datav.dataExcelValue();
	return dataC;

}

public int startScreen() throws IOException {
	int ran=(int) (Math.random() * 90000); 
	File src = driver.getScreenshotAs(OutputType.FILE);
	File des=new File("./snaps/img"+ran+".png");
	FileUtils.copyFile(src, des);
	return ran;

}

public void screenStep(String msg, String status) throws IOException {
	if (status.equalsIgnoreCase("pass")) {
	MediaEntityBuilder.createScreenCaptureFromPath("./snaps/img"+startScreen()+".png");
	} else if(status.equalsIgnoreCase("fail")) {
		MediaEntityBuilder.createScreenCaptureFromPath("./snaps/img"+startScreen()+".png");
	
	}

}

}
