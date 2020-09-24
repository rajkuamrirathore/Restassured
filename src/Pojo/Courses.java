package Pojo;

import java.util.List;

public class Courses {
	
	private List<WebAutomation> webautomation;
	private List<Api> api;
	private List<Moblie> mobile;
	public List<WebAutomation> getWebautomation() {
		return webautomation;
	}
	public void setWebautomation(WebAutomation webautomation) {
		this.webautomation = (List<WebAutomation>) webautomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(Api api) {
		this.api = (List<Api>) api;
	}
	public List<Moblie> getMobile() {
		return mobile;
	}
	public void setMobile(Moblie mobile) {
		this.mobile = (List<Moblie>) mobile;
	}


}
