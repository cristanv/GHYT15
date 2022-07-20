package com.crm.GHYT15.GenericUtility;

import java.util.Random;

/**
 * 
 * @author Cristan
 *
 */


public class JavaUtility {
	/**
	 * its used to Generic Random Number
	 * its Return int data
	 */
	public int getrandomNymber() {
		Random random=new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
	}

	

}
