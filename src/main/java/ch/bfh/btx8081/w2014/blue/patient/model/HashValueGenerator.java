/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * @author Pira
 *
 */
public class HashValueGenerator {
	
		private static String password;
		public static String getHash(String aPassword)
		{
			password = aPassword;
			password = "" + password.hashCode();
			return password;
		}
	}


