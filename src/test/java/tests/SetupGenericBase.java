package tests;

import static io.restassured.RestAssured.baseURI;
import java.util.Locale;
import java.util.Random;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;

public class SetupGenericBase {
	
	Faker faker; 

	@BeforeClass
	public void setUp() {
		
		faker = new Faker(new Locale("pt-BR")); 
		baseURI = "https://petstore.swagger.io/v2";
	}
	
	public String incrementId(String id) {

		Random gerador = new Random();
		String newId = id != null ? id : String.valueOf(gerador.nextInt(1000));
		String requestBody = "{\"id\": " + newId + ",\"petId\": 1,\"quantity\": 1,\"shipDate\": \"2024-04-03T12:24:33.262Z\",\"status\": \"placed\",\"complete\": true}";
		 
		return requestBody;
	}	
}
