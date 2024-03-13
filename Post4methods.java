package jedanest;
import static io.restassured.matcher.RestAssuredMatchers.*; 
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.json.simple.JSONObject;
import org.json.JSONTokener;
import org.json.simple.*;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.response.Response.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class Post4methods {
	
//Making Post request by using different approaches.
//(HashMap,JSONObject, Pojo Class and JSON File)
//Running by TestNG without main method.
String baseURL = "https://bookstore.toolsqa.com";

//@Test	
public void Post1() {
 
 HashMap<String,String> data1 = new HashMap<>();
 data1.put("userName", "Zulu");
 data1.put("password", "1@Wws.(Pgf45");
  
 given().contentType("application/json").body(data1)
 .when().post(baseURL+"/Account/v1/User")
 .then().statusCode(201);
}
 //@Test
public void Post2() {
 
 JSONObject jobj = new JSONObject();
 jobj.put("userName", "Romeo");
 jobj.put("password", "1@Sds.(Pff37");
 
 given().contentType("application/json").body(jobj.toString())  
 .when().post(baseURL+"/Account/v1/User")
 .then().statusCode(201);	
}
 
 //@Test
public void Post3() {
 
 pojo1 pojoObj = new pojo1();
 pojoObj.setUserName("Charlie");
 pojoObj.setPassword("1@Sgs.(P7f67");
 
 given().contentType("application/json").body(pojoObj)  
 .when().post(baseURL+"/Account/v1/User")
 .then().statusCode(201);
 
}
 @Test
 public void Post4() throws FileNotFoundException {
	 
  String jsonfilePath = "C:\\Users\\zikaz\\OneDrive\\Desktop\\REST Assured\\jedanest\\src\\test\\java\\jedanest\\data.json"; 
  File file = new File(jsonfilePath);
  FileReader fr = new FileReader(file);
  JSONTokener jt = new JSONTokener(fr);
  JSONObject jobj2 = new JSONObject(jt);
  
  given().contentType("application/json").body(jobj2.toString())  
  .when().post(baseURL+"/Account/v1/User")
  .then().statusCode(201);
 
 
 
 
 }
 
 
 
 
		
 }



