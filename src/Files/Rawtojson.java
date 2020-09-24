package Files;

import io.restassured.path.json.JsonPath;

public class Rawtojson {
	
	public static JsonPath reuse(String res)
	{JsonPath jj = new JsonPath(res);
		return jj;
		
	}

}
