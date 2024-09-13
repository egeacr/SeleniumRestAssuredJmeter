package insider.automation.api.endpoints;

import insider.automation.api.helper.GlobalData;
import insider.automation.api.payloads.Pet;
import insider.automation.ui.Util.Driver;
import insider.automation.ui.Util.LoggerFactory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Arrays;
import static io.restassured.RestAssured.given;


public class endpoints {

    protected static final Logger logger = LoggerFactory.getLogger(endpoints.class);
    private static GlobalData globalData = new GlobalData();

    public  static Response createPet(Pet payload){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.CREATE_PET);
        return response;
    }


    public static Response updatePet(Pet payload){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.UPDATE_PET);
        return response;
    }


    public static Response getPetWithID(int ID){
        Response response = given()
                .pathParam("petId",ID)
                .when()
                .get(Routes.GET_PET_WITH_ID);
        return response;
    }

    public static Response getPetWithstatus(Status status){

        RequestSpecification spec = new RequestSpecBuilder()
                .addFilters(Arrays.asList(new RequestLoggingFilter())) // log requests and responses
                .build();

        Response response = given(spec)
                .queryParam("status",status.toString())
                .when()
                .get(Routes.GET_PET_WITH_STATUS);
        return response;
    }


    public static Response deletePetWithID(int ID){
        Response response = given()
                .pathParam("petId",ID)
                .when()
                .delete(Routes.DELETE_PET_WITH_ID);
        return response;
    }

    public enum Status{
        available,
        pending,
        sold
    }

}
