package sample.test;

import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class TestRest extends TestBase {

	@Test
	public void _02_checkGetStatus() {
		RequestSpecification request = RestAssured.given();
		Response r = request.get(RestAssured.baseURI);
		r.then().statusCode(200);
		r.then().body("data.id", Matchers.equalTo(2));
		r.then().body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
		r.then().body("data.first_name", Matchers.equalTo("Janet"));
		r.then().body("data.last_name", Matchers.equalTo("Weaver"));
		r.then().body("data.avatar", Matchers.equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));
		logResponse(r);
	}

	private static void logResponse(Response r) {
		Allure.addAttachment("Response", r.body().prettyPrint());
	}

}
