package com.testsuites;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pages.LoginPage;
import com.reusablemethods.BaseSetUp;

public class Datadriven extends BaseSetUp {
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.out.print("Executed before method");
	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void dataDrivenTest() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		setUpBrowser();
		driver.manage().deleteAllCookies();

		File file = new File(System.getProperty("user.dir") + "\\TestData\\TestDataYAML.yaml");
		System.out.println("file name is : " + file);
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).registerModule(new JavaTimeModule())
				.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
		Map<String,Object> testData = objectMapper.readValue(file, Map.class);
		getBrowser().get((String) testData.get("prod1url"));
		System.out.println("Test data is : "+testData.size());
		
		Object name = testData.get("credentials");
		
		System.out.println(""+testData.get("credentials"));
		ArrayList<Object> credentialsList = (ArrayList<Object>) testData.get("credentials");
		System.out.println(credentialsList.size());
		for(int i=0;i<credentialsList.size();i++)
		{
			HashMap<String, String> dataMap = ((LinkedHashMap<String, String>) credentialsList.get(i));
			String userNameValue = dataMap.get("username");
			System.out.println(userNameValue);
			String passwordValue = dataMap.get("password");
			System.out.println(passwordValue);
			loginPage = new LoginPage(getBrowser());
			loginPage.enterusernameandpassword(userNameValue, passwordValue);
			loginPage.clickonSignInButton();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector(".menu-nav")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector(".btn-logout")).click();
			Thread.sleep(5000);
			
		}

//		System.out.println("Application config info " + testData.get("prod1url"));
//		getBrowser().get((String) testData.get("prod1url"));
//		Object array = testData.get("credentials");
//		System.out.println("array"+array);
//		List<Map<String, String>> userList = new ArrayList<>();
//		userList.add((Map<String, String>) array);
		
	//	List<Map.Entry<String, Integer>> list = new ArrayList<>(testData.entrySet());
		
//		   Map<String,Object> name = (Map<String, Object>) testData.get("credentials");
//		   System.out.println(name.size());
//		
//		Map<String, List<String>> mapList = new HashMap<>();
		
//		List<Map<String, String>> userList = new ArrayList<>();
//		userList.add((Map<String, String>) testData.get("credentials"));
//		System.out.println(userList+"userlist");
//		ArrayList<Object> credentialsList = (ArrayList<Object>) testData.get("credentials");
//		Object name = credentialsList.get(0);
//		System.out.println(credentialsList.get(0));

//for (int i = 0; i < array.; i++) {
//    for (int j = 0; j < array2D[i].length; j++) {
//        Object element = array2D[i][j];
//        System.out.print(element + " ");
//    }
//    System.out.println();
//		for (Map<String, String> user : userList) {
//		    String username = user.get("username");
//		    String password = user.get("password");
//		    System.out.println("Username: " + username + ", Password: " + password);
//		}

	        // Create example da

	        // Add data to the list
	        // Iterate over the list of maps
//		for (Map<String, String> data : dataList) {
//            String username = data.get("username");
//            String password = data.get("password");
//
//            System.out.println("Username: " + username);
//            System.out.println("Password: " + password);
//            System.out.println();
//        }
        
//}
	}		

	@AfterClass
	public void afterClass() {
		System.out.print("Executed after method");
	}
}
