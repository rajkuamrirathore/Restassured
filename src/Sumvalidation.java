import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {
	
	//public static void main(String[] args) {
	@Test
	public void sumofcouses(){
		int sum = 0;
		JsonPath js = new JsonPath(Payload.Coursestest());
		int count = js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum+=amount;
		}
		System.out.println(sum);
		
		JsonPath jj = new JsonPath(Payload.Coursestest());
		int purchaseAmount =  jj.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum, purchaseAmount);
	
	}
	
	
}

