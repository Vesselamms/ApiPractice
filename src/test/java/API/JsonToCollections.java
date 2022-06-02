package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class JsonToCollections {

    @BeforeClass
    public void setUpclass() {
        baseURI = "http://54.147.82.143:8000";
    }
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
    public void test1() {
        Response response= given().accept(ContentType.JSON).
                           pathParam("id", 11).
                           and().when().get("/api/spartans/{id}");

        //convert to Collection

        Map<String,Object> map=response.body().as(Map.class);
        System.out.println(map.get("name"));

    }

    @Test
    public void test2(){

        Response response= RestAssured.given().accept(ContentType.JSON)
                           .pathParam("id",11)
                            .and().when().get("/api/spartans/{id}");

        List<Map<String,Object>> list=response.body().as(List.class);

        //print  all data of first maps
        System.out.println(list.get(0));
        Map<String,Object> First=list.get(0);
        System.out.println(First.get("name"));
    }
}
