package API;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import  static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PathMethod {

    @BeforeClass
    public void setUpclass(){
        baseURI="http://54.147.82.143:8000";
    }

    @Test
    public void Test(){
        Response response=given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");
        //verify status code
        assertEquals(response.statusCode(),200);
        //verify content Type
        assertEquals(response.contentType(),"application/json;charset=UTF-8");

        int id=response.body().path("id");
        String name=response.path("name");
        String gender=response.path("gender");
        Long phone=response.path("phone");

        /*System.out.println(response.body().path("id").toString());
        System.out.println(response.body().path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());*/

        assertEquals(id, 10);
        assertEquals(name,"Lorenza");
        assertEquals(gender,"Female");
        assertEquals(phone,3312820936l);

    }

    @Test
    public void test2(){
        Response response=get("/api/spartans");

        //ilk ID
        int firstID=response.path("id[0]");
        //3. name=
        String name=response.body().path("name[2]");
    }
}
