package com.pabb.staarcms.webdriverutility;

import java.util.Random;

/**
 * @author Poornima 
 * 
 * This class is used to store all the generic methods related to Java
 */
public class JavaUtility {

	/**
	 * This Method is used to get the Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int random_number = random.nextInt(1000);
		return random_number;
	}
}
