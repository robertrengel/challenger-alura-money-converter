import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestApi {
    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient(); // Crea una instancia de HttpClient
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies.json")) // Especifica la URL de la API
                    .build();

            // Envía la solicitud a la API y lee la respuesta
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Imprime la respuesta de la API
            System.out.println(httpResponse.body());
        } catch (Exception e) {
            System.out.println("Error al llamar a la API: " + e.getMessage());
        }
    }
}
