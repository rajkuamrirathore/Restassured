import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;



import Pojo.AddPlace;
import Pojo.Location;

public class Serialization {

	public static void main(String[] args) {
	
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();//creating object of Addplace and then calling all the set method via objects
		p.setaccuracy(50);
		p.setaddress("old thippasadra");
		p.setlanguage("english");
		p.setname("rajkuamri");
		p.setwebsite("hello wensite");
		p.setphone_number("7795562694");
		
		//as types is expecting list first create a list 
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("nice");
		mylist.add("yellow");
		p.settypes(mylist);
		
		//creating object of location class as the location varaible delcared is expecting an object
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setlocation(l);
		
		
		
	String res =	given().queryParam("key","qaclick123").body(p)
		.when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(res);

	}

}
