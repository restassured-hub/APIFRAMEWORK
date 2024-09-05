package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification reqq;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqq==null) {
		
		PrintStream log1=new PrintStream(new FileOutputStream("loggin.txt"));
		
		reqq=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
		      .addFilter(RequestLoggingFilter.logRequestTo(log1))
		      .addFilter(ResponseLoggingFilter.logResponseTo(log1)).setContentType(ContentType.JSON).build();
	
	return reqq;
	}
		return reqq;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Kalyan\\eclipse-workspace\\APIFramework\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	
	public String getJsonPath(Response response,String key) {
		String res=response.asString();
		JsonPath js=new JsonPath(res);
		return js.get(key).toString();
		
		
		
	}
}
