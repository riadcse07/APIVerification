/*
 * Mahmud Hasan Riad
 */

package Util;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestInitiator {

	private java.util.List<String> suites;
	public Settings settings;
	private TestListener tla;
	private TestNG testng = null;
	
	public TestInitiator(Settings settings){
		this.settings = settings;
	}
	
	/*public TestInitiator(){
	}*/
	
	public void start(){
		System.out.println("Starting Test ----------");
		
		try	{
			testng = new TestNG();
			testng.setVerbose(0);
			suites = new java.util.ArrayList<String>();
			tla = new TestListener(settings);
			
			String ReportDirectory = "reports/";
			
			testng.setOutputDirectory(Constant.REPORT_PATH+ReportDirectory);
			suites.add(Constant.APP_CONFIG+settings.getTestngxml());
			
			testng.setTestSuites(suites);
			testng.addListener(tla);
			testng.run();
			
		  }
		catch(Exception ex) {
			 ex.printStackTrace();
		}
		
	}
	
	public void stop(){
		System.out.println("Stopping Test ----------");
	}
	
}
