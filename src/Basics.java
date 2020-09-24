import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.Rawtojson;


public class Basics {

	public static void main(String[] args) {
		// Validating an api booking api
		
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	String Response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payload.Addplace()).
	when().post("maps/api/place/add/json")
	.then().log().all().statusCode(200).header("server","Apache/2.4.18 (Ubuntu)")
	.extract().response().asString();
	System.out.println(Response);
	
	JsonPath js = new JsonPath(Response);
	String Placeid= js.getString("place_id");
	System.out.println(Placeid);	
	
	
	//PUT to update the address and will use the same placeid extracted 
	String newAddress = "29, side layout, cohen 09";
	//given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
	//body(Updatepayload.update()).when().put("aps/api/place/add/json").then().log().all().assertThat().statusCode(200)
	//.body("msg", equalTo("Address successfully updated"));
	
	
	//get the updated one
	String Getresponse= given().log().all().queryParam("key","qaclick123").queryParam("place_id",Placeid).when().get("maps/api/place/get/json").
	then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	//JsonPath jj= new JsonPath(Getresponse);
	JsonPath jj = Rawtojson.reuse(Getresponse);
	String actualaddress= jj.getString("address");
	System.out.println(actualaddress);
	Assert.assertEquals(actualaddress, newAddress);
}

	
}
