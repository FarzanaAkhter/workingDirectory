import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SmokeTest 
{
Random rand = new Random();
	
	FirefoxDriver driver = null;
	
	String toDoListName = "Test" + System.currentTimeMillis();
	
	@BeforeClass
	public void before()
	{
		driver = new FirefoxDriver();
		
	}
	
	@AfterClass
	public void after()
	{
		driver.quit();
	}
	@Given("^user is on the home page$")
	public void when_i_open_facebook() throws Throwable
	{
		driver.get("http://amadeus.maclab.org/_demo/nss-todo-1.1/index.php");
			
	   
	    
	}

	@When("^user type to do item in to do item textbox$")
	public void user_type_to_do_itemintodoitemtextbox()  throws Throwable 
	{
		
		
		//Type To Do list name
		driver.findElement(By.name("data")).sendKeys(toDoListName);
		
		//Click add button
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(5000);
		System.out.println("Todo list item is = " + toDoListName);
		
		//Verify To Do item is listed
		verifyToDoItemCreated(toDoListName);	
	}

	@And("^select catagory$")
	public void select_catagory() throws Throwable 
	{

		//Type To Do list name
		driver.findElement(By.name("data")).sendKeys(toDoListName);
		
		//Select Category - Work
		new Select(driver.findElement(By.name("category"))).selectByVisibleText("Work");
		
		//Click add button
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(5000);
		System.out.println("Todo list item is = " + toDoListName);
		
		//Verify To Do item is listed
		verifyToDoItemCreated(toDoListName);	

	   
	}

	@Then("^select due date$")
	public void select_due_date() throws Throwable 
	{
		
		
	   
		//Type To Do list name
				driver.findElement(By.name("data")).sendKeys(toDoListName);
				
				//Select Category - Work
				new Select(driver.findElement(By.name("category"))).selectByVisibleText("Work");
				
				//Select Due Date
				new Select(driver.findElement(By.name("due_day"))).selectByVisibleText("20");
				new Select(driver.findElement(By.name("due_month"))).selectByVisibleText("Jan");
				new Select(driver.findElement(By.name("due_year"))).selectByVisibleText("2015");
				
				//Click add button
				driver.findElement(By.xpath("//input[@value='Add']")).click();
				
				Thread.sleep(5000);
				System.out.println("Todo list item is = " + toDoListName);
				
				//Verify To Do item is listed
				verifyToDoItemCreated(toDoListName);	

	}
	
	
	public void verifyToDoItemCreated(String toDoItem)
	{
		String textFound = driver.getPageSource();
		if(textFound.contains(toDoItem))
		{
			System.out.println("Expected To Do list created");
		}
		else
		{
			System.out.println("Expected To Do list not created");
		}
	}


	
	
	
	

	
	
	

}
