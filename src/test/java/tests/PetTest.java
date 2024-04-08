package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import org.testng.annotations.Test;

@Test
public class PetTest extends SetupGenericBase {
     
	@Test
    public void searchPetsStatusPending() {      
       
        given().queryParam("status", "pending").
        when().get("/pet/findByStatus").
        then().assertThat().statusCode(200).body("status", everyItem(equalTo("pending")));
    }	
	
    @Test
    public void petnotfound() {
    	
        given().pathParam("petId", "9999").
        when().get("/pet/{petId}").
        then().assertThat().statusCode(404);            
    }
	
	@Test
	public void updateaPet() {
		
        String requestBody = "{\"id\": "+faker.number().digit()+",\"category\": {\"id\": 1,\"name\": \""+faker.name().firstName()+"\"},\"name\": \""+faker.name().firstName()+"\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 1,\"name\": \""+faker.name().firstName()+"\"}],\"status\": \"available\"}";
        
        given().contentType("application/json").body(requestBody).
        when().put("/pet").
        then().assertThat().statusCode(200).body("status", equalTo("available")).log().all();
    }
}