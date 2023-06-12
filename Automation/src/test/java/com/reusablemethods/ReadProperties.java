package com.reusablemethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	Properties properties = new Properties();
	String fileSeperator = System.getProperty("file.separator");
	String fileName;
	
	/* Passing the filename by using default constructor */
	public ReadProperties() {
		fileName = "TestData";
	}
	
	/* Parameterized constructor for passing different file */
	public ReadProperties(String file_name) {
		fileName = file_name;
	}
	
	/* This method is used to get the file path of the given file */
	public String getFilePath(String File) {
		String propertiesFilePath;
		String folderPath = System.getProperty("user.dir")+fileSeperator+"TestData";
		propertiesFilePath = folderPath+fileSeperator+File+".properties";
		return propertiesFilePath;
	}
	
	public String getProperty(String key) {
		String value ="";
		try {
			if(key!="")
	        {
				loadPropertiesFile();
				try
				{
					if(!properties.getProperty(key).isEmpty())
						value = properties.getProperty(key).trim();
				}
				catch(Exception e)
				{
					System.out.println("key does not exist or not matched");
				}
	        }
	        else
	        {
	        	System.out.println("!!!!!!!!!!! Key should not be null !!!!!!!!!!!");
	        }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
        return value;
    }
	
	private void loadPropertiesFile()
	{
		try 
		{
			FileInputStream inputStream = new FileInputStream(getFilePath(fileName));
			properties.load(inputStream);
			inputStream.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Cannot find configuration file");
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot read configuration file");
		}
	}
		
}
