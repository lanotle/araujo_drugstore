package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

@Test
public class StoreTest  extends SetupGenericBase {
	
	@Test
	public void testPlaceanOrder() {
		
		String requestBody = incrementId(null);
		given().contentType("application/json").body(requestBody).
		when().post("/store/order").
		then().assertThat().statusCode(200).body("status", equalTo("placed")).log().body();
	}

	@Test
	public void testPlaceaninvalidOrder() {
		
		String requestBody = incrementId("AAA");
		given().contentType("application/json").body(requestBody).
		when().post("/store/order").
		then().assertThat().statusCode(400).log().all();
	}
}