package com.techolution;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.techolution.App;
import com.techolution.domain.InputItems;
import com.techolution.service.SatisfactionService;
import com.techolution.util.FileParsingUtility;
/**
 * 
 * @author Yoga Chandran
 * Main class 
 */

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.techolution")
public class App 
{
    public static void main( String[] args )throws IOException, Exception
    {
    	/**
    	 * Below code is used to load the beans from the spring context
    	 */
    	ApplicationContext context = SpringApplication.run(App.class);
    	FileParsingUtility fileParsingUtility = context.getBean(FileParsingUtility.class);
    	//This method reads the file stored in src/main/resources folder
    	InputItems inputItems = fileParsingUtility.readFile();
    	SatisfactionService satisfactionService = context.getBean(SatisfactionService.class);
    	satisfactionService.setInputItems(inputItems);
    	System.out.println("============== Calculating Maximum Satisfaction value for the given time in Minutes =================");
    	int totalSatisfactionCalcInMinutes = satisfactionService.calculateMaxSatisfactionInMinutes();
    	System.out.println("Max satisfaction from eating "+inputItems.getTotalItems()+" in minutes is: "+totalSatisfactionCalcInMinutes);
    	System.out.println("============== Calculating Maximum Satisfaction value for the given time in Seconds =================");
    	int totalSatisfactionCalcInSeconds = satisfactionService.calculateMaxSatisfactionInSeconds();
    	System.out.println("Max satisfaction from eating "+inputItems.getTotalItems()+" in seconds is: "+totalSatisfactionCalcInSeconds);
    	

    }
}
