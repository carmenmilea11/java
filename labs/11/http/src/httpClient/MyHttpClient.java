package httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static void main(){

        try (HttpClient httpClient = HttpClient.newHttpClient()) {

            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI("https://www.google.com"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient
                    .send(httpRequest,HttpResponse.BodyHandlers.ofString());

            System.out.println(httpResponse.statusCode());
            System.out.println(httpResponse.body());

            HttpResponse<String> httpResponse2 = httpClient
                    .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).join();

            System.out.println(httpResponse2.statusCode());
            System.out.println(httpResponse2.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
