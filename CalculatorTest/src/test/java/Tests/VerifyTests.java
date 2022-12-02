package Tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.registrationPage;

public class VerifyTests extends TestsParameters {

	
	@Test(priority=1)
	public void signUp()throws  Exception {
		
		registrationPage register = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
	try {
		System.out.println("SIGN IN TEST");
		register.ClickCreateNewUser();
		String[] userInfo = users.get(1).split(",", 2);
		register.EnterPersonalData(userInfo[0],userInfo[1]);
		register.ClickButtonSignUp();
		register.CatchUserName();
		register.ClickLogout();
		}catch(Exception e) {
			System.out.println("Sign up. Something went wrong");
		}
	}

	
	@Test(priority=2)
	public void login() throws Exception {
      
		loginPage login = new loginPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("LOGIN TEST");
		      String[] userInfo = users.get(1).split(",", 2);
		      login.TypePersonalData(userInfo[0],userInfo[1]);
		      login.ClickButtonLogin();
		      login.CatchUserName();
		      login.ClickLogout();
		  
              }catch(Exception e) {
	           System.out.println("Login. Something went wrong");
              }
			}

//	Negative login test with wrong name
	@Test(priority=3)
	public void loginWrongName() throws Exception {
      
		loginPage loginWrongName = new loginPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("LOGIN TEST WITH WRONG userNAME");
		      String[] userInfo = users.get(2).split(",", 2);
		      loginWrongName.TypePersonalData(userInfo[0],userInfo[1]);
		      loginWrongName.ClickButtonLogin();
		      loginWrongName.CatchErrorMessage();
		      
              }catch(Exception e) {
	           System.out.println("Login with wrong name. Something went wrong");
              }
			}

	 
// Negatives tests of registration
	
	@Test(priority=4)
	public void registrationOnlyName() throws Exception {
      
		registrationPage registrationOnlyName = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("REGISTRATION TEST WITH ENTERED ONLY NAME");
		      String[] userInfo = users.get(3).split(",", 2);
		      registrationOnlyName.ClickCreateNewUser();
		      registrationOnlyName.EnterPersonalData(userInfo[0],userInfo[1]);
		      registrationOnlyName.ClickButtonSignUp();
		      registrationOnlyName.CatchOnlyNameError();
		      registrationOnlyName.ClearData();
		      
              }catch(Exception e) {
	           System.out.println("Registration with only name. Something went wrong");
              }
			}

	@Test(priority=5)
	public void registrationOnlyPsw() throws Exception {
      
		registrationPage registrationOnlyPsw = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("REGISTRATION TEST WITH ENTERED ONLY PASSWORD");
		      String[] userInfo = users.get(4).split(",", 2);
		      registrationOnlyPsw.EnterCredentials(userInfo[0],userInfo[1]);
		      registrationOnlyPsw.ClickButtonSignUp();
		      registrationOnlyPsw.CatchOnlyPswError();
		      registrationOnlyPsw.ClearData();
              }catch(Exception e) {
	           System.out.println("Something went wrong");
              }
			}
	
	
	@Test(priority=6)
	public void registrationNoPersonalData() throws Exception {
      
		registrationPage registrationNoPersonalData = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("REGISTRATION TEST WITH NO ENTERED PERSONAL DATA");
			      String[] userInfo = users.get(5).split(",", 2);
			      registrationNoPersonalData.EnterCredentials(userInfo[0],userInfo[1]);
			      registrationNoPersonalData.ClickButtonSignUp();
			      registrationNoPersonalData.CatchOnlyNameError();
			      registrationNoPersonalData.CatchOnlyPswError();
			      registrationNoPersonalData.ClearData();
              }catch(Exception e) {
	           System.out.println("Something went wrong");
              }
			}
	
	@Test(priority=7)
	public void registrationWithUsedUsername() throws Exception {
      
		registrationPage registrationWithUsedUsername = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("REGISTRATION TEST WITH ALREADY USED USERNAME");
			      String[] userInfo = users.get(6).split(",", 2);
			      registrationWithUsedUsername.EnterCredentials(userInfo[0],userInfo[1]);
			      registrationWithUsedUsername.ClickButtonSignUp();
			      registrationWithUsedUsername.CatchWithUsedUsernameError();
			      registrationWithUsedUsername.ClearData();
		    	
              }catch(Exception e) {
	           System.out.println("Something went wrong");
              }
			}
	
	
	@Test(priority=8)
	public void registrationPasswordsDontMatch() throws Exception {
      
		registrationPage registrationPasswordsDontMatch = new registrationPage(driver);
		ArrayList<String> users = getTestDataArray("C:\\Users\\danng\\eclipse-workspace\\CalculatorTest\\Duomenys\\login.txt");
		    try {
		    	System.out.println("REGISTRATION TEST WHEN PASSWORDS DONT MATCH");
			      String[] userInfo = users.get(7).split(",", 2);
			      registrationPasswordsDontMatch.TypeCredentials(userInfo[0],userInfo[1]);
			      registrationPasswordsDontMatch.ClickButtonSignUp();
			      registrationPasswordsDontMatch.CatchPasswordsDontMatchError();
			      registrationPasswordsDontMatch.ClearData();
		    	
              }catch(Exception e) {
	           System.out.println("Something went wrong");
              }
			}
	
//Metodai


	public static ArrayList<String> getTestDataArray(String myFile) throws Exception {
		ArrayList<String> listOfLines = new ArrayList<String>();
		String line;

		FileReader FR = new FileReader(myFile);
		BufferedReader BR = new BufferedReader(FR);
		line = BR.readLine();

		while (line != null) {
			listOfLines.add(line);
			line = BR.readLine();
		}
		BR.close();
		return listOfLines;
	}
	

	
	
	
}