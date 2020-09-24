import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pojo.GetCourses;

public class AuthOperation {

	public static void main(String[] args) {
		
	/*	System.setProperty("webdriver.chrome.driver","/Users/rajkumari.rathore/Downloads/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=abcdefg");
		
		 driver.findElement(By.cssSelector("input[type='email']")).sendKeys("rajkumari.brathore@gmail.com");
		 driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		 driver.findElement(By.cssSelector("input[type='password']")).sendKeys("**************");
		 driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		 driver.getCurrentUrl(); */
		
		//getting the "code" by manually hitting the below url on browser
		 String url = "https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FzAGTf6C25aixpGUeY2dbbHf4araiKqAT0Xrql3-LfHgnUpeOe15Dqp6jOP7tnmAS8WTA3WGxY7tABA1UbglcbeI&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];  //getting the value of code
		System.out.println(code);
		
		
		
	//getting the "accesstoken" by adding the above code into the below api	
		
	String token =	given().urlEncodingEnabled(false).
		queryParams("code",code).
		queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		queryParams("redirect_url","https://rahulshettyacademy.com/getCourse.php").
		queryParams("grant_type","authorization_code").
		queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email").
		queryParams("state", "verifyfjdss").
      queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8").
		when().post("https://www.googleapis.com/oauth2/v4/token").asString();
	    System.out.println(token);
		JsonPath js = new JsonPath(token);
		String accesstoken = js.get("access_token");
		System.out.println(accesstoken);
		
		
		
		//hitting the main api of rahulshetting 
		
	GetCourses res =	given().queryParam("access_token",accesstoken).expect().defaultParser(Parser.JSON).
		when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
  //	System.out.println(res);  
	System.out.println(res.getLinkedin());
	System.out.println(res.getInstructor());
	
	}
	

}
