

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.junit.Test;
import org.testng.annotations.DataProvider;




public class Dynamicpayload {

//public static void main(String[] args) {}
	
	@Test(DataProvider="add")
	public void Addbook(String isbn, String aisle ) {
	RestAssured.baseURI = "http://216.10.245.166";
String res = 	given().log().all().header("Content-Type","application/json").body(Payload.Addpayload(isbn,aisle)).
	when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(res);
	
	JsonPath js = new JsonPath(res);
	js.getString("ID");
	System.out.println(js.getString("ID"));}
	
	@DataProvider(name="add")
	public Object[][] getdata()
	{
		return new Object[][] {{"nvkodo","6050654"},{"nbvkfnd","024305u"},{"kcnvkdfi","04830"}};
	}
	
	
		
	
	
}
