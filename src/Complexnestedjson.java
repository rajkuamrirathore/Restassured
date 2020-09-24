import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Complexnestedjson {

	public static void main(String[] args) {
		JsonPath js= new JsonPath(Payload.Coursestest());
		
		//printing the size of the courses present in the payload class
		int coursessize = js.getInt("courses.size()");
		System.out.println(coursessize);
		
		//print the purchase amount present in the payload class
		int puchaseamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(puchaseamount);
		
		// printing title of the first course
		String firsttitle = js.getString("courses[0].title");
		System.out.println(firsttitle);
		
		//printing all the data of the courses
		for(int i =0;i<coursessize;i++)
		{
			String coursetitle = js.getString("courses["+i+"].title");
			System.out.println(coursetitle);
			System.out.println(js.getInt("courses["+i+"].price"));
		}
			//printing the copies sold under RPA
			System.out.println("printing the copies under RPA");
			for(int j=0;j<coursessize;j++)
			{
				String coursetitle = js.getString("courses["+j+"].title");
				if(coursetitle.equalsIgnoreCase("RPA"))
				{
					System.out.println(js.getInt("courses["+j+"].copies"));
				}
			}
		}

	}


