package MavenFirst.FirstPrjMaven;

import static com.jayway.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class LandLord {
	
	//@Test
/*	public void getInfo(){
	Response response=
			given().queryParam("firstName", "anna")
			
			.when().get("http://localhost:8080/landlords");
	
				System.out.println("content type="+response.getContentType());
				System.out.println("header info="+response.getHeaders());
				System.out.println("body content="+response.getBody().asString());
				response.then().assertThat().statusCode(200);
				response.then().assertThat().time(lessThan(3000L));
				response.then().assertThat().body("[0].firstName",Matchers.equalTo("anna"));
				
				
		
	}*/
	
	/*@Test
	public void AddData(){
		Response res=given()
		.contentType(ContentType.JSON)
	.body("{"
			+ "\"firstName\": \"anna\","
			+"\"lastName\": \"sa\""
			+"}")
	
	
	.when()
		.post("http://localhost:8080/landlords");
			res.then()
		.statusCode(201)
		.extract().response().prettyPrint();
	}*/
	
	/*@Test
	
		public void EditData(){
			Response res=given()
			.contentType(ContentType.JSON)
		.body("{"
				+ "\"firstName\": \"sara\","
				+"\"lastName\": \"kl\""
				+"}")
		

			
			.put("http://localhost:8080/landlords/5nyevzbU");
			res.then()
			//.body("message : LandLord with id: 5nyevzbU successfully updated", null)
			.statusCode(200)
			.extract().response().prettyPrint();
			
			
	}*/
	
	
	/*@Test
	public void Validate(){
		Response response=
						given().queryParam("firstName", "sara")
				
				.when().get("http://localhost:8080/landlords");
		
					System.out.println("content type="+response.getContentType());
					System.out.println("header info="+response.getHeaders());
					System.out.println("body content="+response.getBody().asString());
					response.then().assertThat().statusCode(200);
					response.then().assertThat().time(lessThan(3000L));
					response.then().assertThat().body("[1].id",Matchers.equalTo("5nyevzbU"));
					response.then().statusCode(200);
			
		}*/
		
	

	public void Validate_delete(){
		Response res=given()
				.contentType(ContentType.JSON)
				.delete("http://localhost:8080/landlords/5nyevzbU");
				res.then()
				.statusCode(200)
				.extract().response().prettyPrint();
				res.then().assertThat().body("[0].id",Matchers.equalTo("5nyevzbU"));
				res.then().statusCode(404);
				System.out.println("content type="+res.getContentType());
	}
}