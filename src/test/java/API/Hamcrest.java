package API;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class Hamcrest {

    @BeforeClass
    public void setUpclass(){baseURI = "http://54.147.82.143:8000";}
    /*Given Accept type is JSON,
    and Pathparam Spartan id is 11
    When user request the /spartans/{ıd}
    Then status code is 200
    and contenttype is Json
    and "id"=11
            "name"="Nona"
            "gender"="Female"
            "phone"=795265235
            */

    @Test
    public void test1(){

                          given().accept(ContentType.JSON).
                          pathParam("id",15).
                          get("/api/spartans/{id}").
                          then().statusCode(200).
                          and().contentType("application/json;charset=UTF-8");
    }


    @Test
    public void test2(){
            given().accept(ContentType.JSON).
                    pathParam("id",15)
                    .get("/api/spartans/{id}")
                    .then().assertThat().statusCode(200)
                    .assertThat().contentType("application/json;charset=UTF-8")
                    .and().assertThat().body("id", Matchers.equalTo(15),"name",Matchers.equalTo("Meta"),"gender",
                    Matchers.equalTo("Female"));
    }
}
