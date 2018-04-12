package MavenFirst.FirstPrjMaven;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;


public class GoogleApiTests {
	public static String placeId;

	@BeforeTest
	public void setUp(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
	}
	
	@Test(enabled=false)
	public void GetDistanceMatrix(){
		given()
		.queryParam("origins","newyork")
		.queryParam("destinations","SanFrancisco")
		.queryParam("mode","car")
		.queryParam("language","fr-FR")
		.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
		.when()
			.get("/distancematrix/json")
		.then()
			.statusCode(200)
			.and()
			.assertThat().body("rows[0].elements[0].distance.value",Matchers.equalTo(4676417))
			.extract().response().prettyPrint();
	}
	@Test(priority=1,enabled=false)
	public void AddPlaces(){
			Response res=given()
		.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
		.contentType(ContentType.JSON)
		.body("{"
				+ "\"location\": {"
				+ "\"lat\": -33.8669810,"
				+ "\"lng\": 151.1958790"
				+ "},"
				+ "\"accuracy\": 50,"
				+ "\"name\": \"tekarch new place1\","
				+ "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\""
				+ "}")
		.when()
			.post("/place/add/json");
			placeId=res.body().path("place_id");
		System.out.println("place id="+placeId);
		res.then()
			.statusCode(200)
			.extract().response().prettyPrint();
	}
	
	@Test(priority=1)
	public void AddPlaceswithPojo(){
		Location loc=new Location(-33.8669710,151.1958750);
		List<String> types=new ArrayList<String>();
		types.add("shoe_store");
		Places places=new Places(loc, 50, "my new shop", "3435","dfjsd dkfjsdkf",types,"www.type.com","english");

		Response res=
		given()
			.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
			.contentType(ContentType.JSON)
			.body(places)//// converting java pojo to json request-->serialization
		.when()
			.post("/place/add/json");
		
		placeId=res.body().path("place_id");//retrieving place_id from json body and storing in placeId
		
		// converting json response to java pojo-->de serialization
		ResPojo resObj=res.as(ResPojo.class);
		System.out.println("scope of response="+resObj.scope);
		
		res.then()
			.statusCode(200)	//validating thestatus code
			.extract().response().prettyPrint(); //printing the response to console
	}
	@Test(priority=2)
	public void getDetailsOnPlace(){
		Response res=given()
				.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
				.queryParam("placeid", placeId)
		.when()
				.get("/place/details/json");
		
		res.prettyPrint();
		
	}
	
	@Test(priority=3)
	public void DeleteNewlyAddedPLace(){
		Response res=given()
				.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
				.contentType(ContentType.JSON)
				.body("{\"place_id\": \""+placeId+"\"}")
		.when()
				.post("/place/delete/json");
		
		//res.then().statusCode(200);
		res.prettyPrint();
		
	}
}
