package API;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import  static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.baseURI;

public class JsonMethod {

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
    public void Test1() {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("api/spartans/{id}");

        assertEquals(response.statusCode(),200);

        JsonPath jsonPath=response.jsonPath();

        int id1=jsonPath.getInt("id");
        String name=jsonPath.getString("name");
        String gender=jsonPath.getString("gender");
        Long phone=jsonPath.getLong("phone");

        assertEquals(id1,11);
        assertEquals(name,"Nona");
        assertEquals(gender,"Female");
        assertEquals(phone,795909526l);
    }

}