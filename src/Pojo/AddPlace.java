package Pojo;

import java.util.List;

public class AddPlace {
	
	private Location location;
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private List<String> types;
	
	
	//getter and setter for location
	public Location getlocation(){
		return location;
	}
	
	public void setlocation(Location location){
		this.location = location;
	}
	
	
	//getter and setter for type
		public List<String> gettypes(){
			return types;
		}
		
		public void settypes(List<String> types){
			this.types = types;
		}
	
	
	
	//getter and setter for accuracy
	public int getaccuracy() {
		return accuracy;
	}
	public void setaccuracy(int accuracy) {
		this.accuracy=accuracy;
	}
	
	//getter and setter for name
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name=name;
		}
		
		//getter and setter for phone_number
		public String getphone_number() {
			return phone_number;
		}
		public void setphone_number(String phone_number) {
			this.phone_number=phone_number;
		}
		
		//getter and setter for address
		public String getaddress() {
					return address;
				}
		public void setaddress(String address) {
					this.address=address;
				}
		
				
				//getter and setter for website
		public String getwebsite() {
					return website;
				}
		public void setwebsite(String website) {
					this.website=website;
				}
		
				//getter and setter for language
		public String getlanguage() {
					return language;
				}
		public void setlanguage(String language) {
					this.language=language;
				}
		

}
