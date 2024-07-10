package ApiConectionTests;

import org.example.ApiServiceConnections.ClassFeaturesHanlder;
import org.example.ApiServiceConnections.ClassResourcesHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

public class ClassFeaturesHandlerTests {

    @Mock
    private HttpResponse<String> response;
    @Mock
    HttpClient client;
    @Mock
    HttpRequest request;

    public void setResponse(String responseBody,int statusCode){
        when(response.statusCode()).thenReturn(statusCode);
        lenient().when(response.body()).thenReturn(responseBody);
    }

    @Test
    public void testStuff(){
        //ClassFeaturesHanlder testObj = new ClassFeaturesHanlder(client);

        when(response.statusCode()).thenReturn(404);
        System.out.println(response.statusCode());
        Assertions.assertEquals(404, response.statusCode());
    }

}
