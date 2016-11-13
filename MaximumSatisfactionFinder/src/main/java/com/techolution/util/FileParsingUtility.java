package com.techolution.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.techolution.domain.InputItems;
import com.techolution.domain.MenuItem;

/**
 * 
 * @author Yoga Chandran
 * FilerParsingUtility.java -> For reading the .txt file and convering into pojo
 */
@Component
public class FileParsingUtility {

	@Value("${input.file.name}")
	private String fileName;

	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * This method reads the file and converts into InputItems object
	 * @return InputItems
	 */
	public InputItems readFile(){

		InputItems inputItem = null;
		try{
			if(null==fileName){
				throw new FileNotFoundException("FileName not configured in the properties file!!");
			}
			Resource resource = resourceLoader.getResource("classpath:" + fileName);
			File fileRead = resource.getFile();

			if(null == fileRead){
				throw new FileNotFoundException(" Please provide a valid file location ");
			}

			BufferedReader br = new BufferedReader(new FileReader(fileRead));
			String firstLine = br.readLine();
			String values[] = firstLine.split(" ");
			int minutesToEat = Integer.parseInt(values[0]);
			int numberOfItems = Integer.parseInt(values[1]);
			//System.out.println("To find the Maximum Satisfaction from eating  " + numberOfItems + " items in "	+ minutesToEat + "mins/secs");
			List<MenuItem> menuItemList = formMenuItems(br);
			br.close();
			inputItem = new InputItems(menuItemList, numberOfItems, minutesToEat);
		}
		catch(IOException e){
			System.err.println("Error while reading file: "+e.getMessage());
		}
		catch(Exception e){
			System.err.println("Error exceuting the method readFile(): "+e.getMessage());
		}
		return inputItem;

	}

	/**
	 * This method is used to create list of menuitem objects from the input file
	 * @param bufferedReader
	 * @return List<MenuItem>
	 */
	private List<MenuItem> formMenuItems(BufferedReader bufferedReader){
		String currentLine = null;
		String[] values;
		int itemId = 0;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		try {

			while ((currentLine = bufferedReader.readLine()) != null) {
				itemId++;
				values = currentLine.split(" ");
				int satisfactionValue = Integer.parseInt(values[0]);
				int seconds = Integer.parseInt(values[1]);
				MenuItem menuItem = new MenuItem(itemId, seconds, satisfactionValue);
				menuItemList.add(menuItem);
				//System.out.println(satisfactionValue + " in  " + seconds + " seconds");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
