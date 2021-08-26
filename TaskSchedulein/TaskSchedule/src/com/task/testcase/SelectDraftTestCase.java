package com.task.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.task.helper.Xlutility;
import com.task.testpage.DraftPage;
import com.task.testpage.SheetPage;
import com.task.testpage.TaskPage;




public class SelectDraftTestCase {
	public static WebDriver driver;
	Xlutility xl = new Xlutility();
   // LoginPage page;
	SelectDraftTestCase() {

		/*System.setProperty("webdriver.chrome.driver",
				"D:\\ASSIGN\\New folder (2)\\chromedriver.exe");*/
		System.setProperty("webdriver.chrome.driver",
				"./Browsers/chromedriver.exe");
		driver = new ChromeDriver();
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
		System.out.println("hai");
		String Output_excel = "./xlfolder/datasource1.xls";
		int rowcount = xl.getRowCount(Output_excel, "Sheet1");
		System.out.println("hai");
		String username = xl.readExcel12(0, 1);
		String password = xl.readExcel12(1, 1);
		String date = xl.readExcel12(2, 1);
		String description = xl.readExcel12(3, 1);

		System.out.println("hai");
		
		DraftPage page = PageFactory.initElements(driver,
				DraftPage.class);
		//page = new TaskPage(driver);
		System.out.println("hai");
		page.main(driver, username, password,date,description);
	}

	public static WebDriver getDriver() {
		return driver;
	}
		 
}
