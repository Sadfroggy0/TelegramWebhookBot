package ru.timofey.tgbot2;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.timofey.tgbot2.httpConnection.HttpHeadHunterRequest;

public class JsonTest {
    private static HttpHeadHunterRequest request;

    public HttpHeadHunterRequest getRequest() {
        return request;
    }


    @BeforeClass
    public static void utilsInitialization(){
         request = new HttpHeadHunterRequest("https://api.hh.ru/vacancies");
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://api.hh.ru/vacancies","https://api.hh.ru/vacancies?text=java","https://api.hh.ru/vacancies?text=математика"})
    public void SomeRequestedJsonsShouldNotBeEmpty( String url){
        HttpHeadHunterRequest httpHeadHunterRequest = new HttpHeadHunterRequest(url);
        Assert.assertNotNull(httpHeadHunterRequest.getJsonString());
    }

    @Test
    public void JsonShouldNotBeNull(){
        Assert.assertNotNull(request.getJsonString());
    }

    @Test(timeout = 1000)
    public void shouldReturnStringBuilder(){
        Assert.assertEquals(StringBuilder.class, request.getJsonString().getClass());
    }


}
