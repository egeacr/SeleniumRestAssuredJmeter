package insider.automation.api.endpoints;

public class Routes {

    public static String base_URL= "https://petstore.swagger.io/v2";
    public static String CREATE_PET = base_URL+"/pet";
    public static String GET_PET_WITH_ID = base_URL+"/pet/{petId}";
    public static String UPDATE_PET = base_URL+"/pet";
    public static String GET_PET_WITH_STATUS = base_URL+"/pet/findByStatus";
    public static String DELETE_PET_WITH_ID=base_URL+"/pet/{petId}";
}
