package com.task.testcase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.task.helper.Xlutility;
import com.task.testpage.TaskPage;
public class TaskLoginTestCase {
	public static WebDriver driver;
	Xlutility xl = new Xlutility();
   // LoginPage page;
	TaskLoginTestCase() {
		
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",
				//"D:\\ASSIGN\\New folder (6)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		/*System.setProperty("webdriver.firefox.marionette",
				"D:\\ASSIGN\\New folder (2)\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		driver.manage().window().maximize();
		// u r l
		//driver.get("http://192.168.20.66:8097/BSNLThinApp/Login.do");
        driver.get("http://13.71.114.248:2017/Uniserve-Web/fortunetech/LogInAction.do");

	}
	@Test
	public void login() throws Exception {
		String Output_excel = "./xlfolder/datasource1.xls";
		//String Output_excel = "D:\\RJIO12\\TaskSchedule\\xlfolder\\datasource1.xls";
		int rowcount = xl.getRowCount(Output_excel, "Sheet1");
		
		for(int i=1;i<=23;i++){
	
		String username = xl.readExcel12(0, 1);
		String password = xl.readExcel12(1, 1);
	 	String date = xl.readExcel12(2, i);
	 	System.out.println("pooooooooooooooo");

		String description = xl.readExcel12(3, i);
		String client = xl.readExcel12(4, 1);
		String client1 = xl.readExcel12(5, 1);
		String description1 = xl.readExcel12(6, 1);
		System.out.println("pooooooooooooooo");

		String crname = xl.readExcel12(7, 1);
		String stageName = xl.readExcel12(9, 1);
		System.out.println("pooooooooooooooo");
		TaskPage page = PageFactory.initElements(driver,
				TaskPage.class);
		//page = new TaskPage(driver);
		
		page.test(driver, username, password,date,description,client,client1,description1,crname,stageName);
	}
	}
	public static WebDriver getDriver() {
		return driver;
	}
		 
}
