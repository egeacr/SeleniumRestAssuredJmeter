package insider.automation.api.test;

import com.github.javafaker.Faker;
import insider.automation.api.endpoints.endpoints;
import insider.automation.api.helper.GlobalData;
import insider.automation.api.payloads.Category;
import insider.automation.api.payloads.Pet;
import insider.automation.api.payloads.Tags;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class APITestScenarios {

    Pet petPayload;
    endpoints pet = new endpoints();
    private static final Logger logger = LogManager.getLogger(endpoints.class);
    private static GlobalData globalData = new GlobalData();
    Faker faker = new Faker();

    @BeforeClass
    public void setupData(){

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("first url");
        photoUrls.add("second url");

        String categoryName = faker.dog().gender();
        int categoryId = faker.number().numberBetween(1,100);

        Category category = new Category(categoryId, categoryName);

        List<Tags> tags = new ArrayList<>();
        tags.add(new Tags(2, "home"));
        tags.add(new Tags(3, "N/A"));
        int petId = faker.number().numberBetween(1,10000);

        String name = faker.dog().name();

        petPayload = new Pet(petId, "available",
                name, photoUrls,category, tags);
    }

    @Test(priority = 0)
    public void createPet(){
        Response response = pet.createPet(petPayload);

        Assert.assertEquals(response.getStatusCode(), 200);
        int createdPetId = response.jsonPath().getInt("id");
        String createdPetName = response.jsonPath().getString("name");
        globalData.set("createdPetId", createdPetId );
        globalData.set("createdPetName", createdPetName );
        logger.info("Pet created with ID = " + createdPetId + "and name = " + createdPetName);
    }



    @Test(priority = 1)
    public void getPet(){
        Response response = pet.getPetWithID(globalData.getInt("createdPetId"));
        Pet petResponse = response.getBody().as(Pet.class);
        logger.info(petResponse.getId()+" and "+petResponse.getName());

        Assert.assertEquals(petResponse.getId(),globalData.getInt("createdPetId"));
        Assert.assertEquals(petResponse.getName(),globalData.get("createdPetName"));
    }

    @Test(priority = 2)
    public void updatePetName(){

        petPayload.setName("zeytin");


        Response response = pet.updatePet(petPayload);

        Pet petResponse = response.getBody().as(Pet.class);
        Assert.assertEquals(petResponse.getName(), "zeytin");
    }

    @Test(priority = 3)
    public void beforeDeletionWithID(){
        Response response = pet.getPetWithID(globalData.getInt("createdPetId"));
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 4)
    public void deletePetWithID(){
        Response response = pet.deletePetWithID(globalData.getInt("createdPetId"));
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test(priority = 5)
    public void verifyDeletionWithID(){

        try {
            Response response = pet.getPetWithID(globalData.getInt("createdPetId"));
            response.then().statusCode(404);
        } catch (Exception e) {
        }
    }

    @Test (priority = 6)
    public void getPetsWithStatus(){
       endpoints.Status status = endpoints.Status.sold;
        Response response = pet.getPetWithstatus(status);
        Pet [] pets = response.as(Pet[].class);
        logger.info(pets.length);

       }
}
