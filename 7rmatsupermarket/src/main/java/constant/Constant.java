package constant;

public class Constant {

	// copy the excel path in a variable

	public static final String TESTDATA = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	// system- class, getPtoprty- method,user.dir -directory
	public static final String TESTIMAGE = System.getProperty("user.dir") + "\\src\\test\\resources\\mango.jpg";

	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public static final String LOGINVALIDCREDENTIALS = "unable to load the page after entering valid username and password";
	public static final String LOGININVALIDUSERNAME = "able to load the page after entering invalid username and valid password";
	public static final String LOGININVALIDPASSWORD = "able to load the page after entering valid username and invalid password";
	public static final String LOGININVALIDCREDENTIALS = "able to load the page after entering invalid username and password";
	public static final String LOGOUT = "unable to logout.";
	public static final String ADDADMIN= "unable to add admin.";
	public static final String ADDCATEGORY = "unable to add category";
	public static final String UPDATECONTACT = "unable to update contact.";
	public static final String UPDATEFOOTER = "unable to update footer.";
	public static final String MANAGENEWS = "unable to add news.";

}
