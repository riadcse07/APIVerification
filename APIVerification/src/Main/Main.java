/*
 * Mahmud Hasan Riad
 */

package Main;

import Util.Settings;
import Util.TestInitiator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Settings setting = new Settings();
		
		System.out.println("\n========================");
		System.out.println("Test Execution Started.");
		System.out.println("=======================\n");
		
		TestInitiator ts = new TestInitiator(setting);
		ts.start();
			
	}

}
