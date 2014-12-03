/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.database;

import java.util.TreeMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import ch.bfh.btx8081.w2014.blue.patient.model.Patient;

/**
 * @author Pira
 *
 */
public class Data {

	private static TreeMap<String, User> users = new TreeMap<String, User>();
	private static String user = "default";
	private static String reference = "default";

	public static void loadUsers()
	{
	try {
		String username = null;
		String password = null;
		Document jdom = new SAXBuilder().build("XML/users_data.xml");
		Element usersRoot = jdom.getRootElement();
		for(Element user : usersRoot.getChildren())
		{
			username = user.getChild("Username").getValue();
			password = user.getChild("Passwort").getValue();
			users.put(username, new User(username, password));
			System.out.println(username);
			System.out.println(password);
		}
	}
	catch (Exception e) {
		System.out.println("no connection to user data possible");
	}
	}
	
//	users.put("administrator@bfh.ch", new User("administrator@bfh.ch", "321"));

	public static void setUser(String aUser)
	{
		user = aUser;
	}
	public static String getReference()
	{
		return reference;
	}
	public static String getUser()
		{
			return user;
		}
	/**
	 * Returns the TreeMap users
	 * @return users
	 */
	public static TreeMap<String, User> getUsers()
	{
		return users;
	}
	}
