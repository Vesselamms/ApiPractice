package API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QureyParam {

@BeforeClass
public void setUpclass(){
    RestAssured.baseURI="http://54.147.82.143:8000";
}
    @Test
    public void qureyParam(){

        Response response= RestAssured.given().accept(ContentType.JSON)
                                    .and().queryParam("Gender","Female")
                                    .and().queryParam("nameContains", "j")
                                    .when().get("/spartans/api/search");


        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
        Assert.assertTrue(response.body().asString().contains("Female"));
        Assert.assertTrue(response.body().asString().contains("Janette"));
    }
}
