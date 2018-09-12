package project.features;

import java.lang.reflect.Field;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.JUnitReporter;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import project.utilities.ExcelUtils;



public class CucumberHooks {
	
	@ManagedPages
	private Pages pages;
	
   
    
	@After
    public void cleanUp(Scenario sScenario) throws Exception{ 
    	
		Field f = sScenario.getClass().getDeclaredField("reporter");
        f.setAccessible(true);
        JUnitReporter reporter =(JUnitReporter) f.get(sScenario);
        
         Field executionRunnerField = reporter.getClass().getDeclaredField("executionUnitRunner");
         executionRunnerField.setAccessible(true);
         ExecutionUnitRunner executionUnitRunner =(ExecutionUnitRunner) executionRunnerField.get(reporter);
        
         String sScenarioOutline =executionUnitRunner.getDescription().getDisplayName();
     
        
    	String sStatus = sScenario.getStatus();
    	
    	String sTCname = sScenario.getName()+sScenarioOutline;
    	String sFeatureName = sScenario.getId().split(";")[0].replace("-", " ");

    	  		
    		pages.getDriver().quit();
   
	    
    	String sDirectory = System.getProperty("user.dir");
    	String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
		String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";
    	  
	    int iScenarioCount = ExcelUtils.SetCellDataXlsm(sFeatureName,sTCname,sStatus,sExcelPath);

    	if (iScenarioCount % 20 == 0)
    		Runtime.getRuntime().exec(new String[] { "wscript.exe", sDriverPath+"\\Trigger.vbs",sExcelPath}); 
 
    }

}
