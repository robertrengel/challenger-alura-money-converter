import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//import netscape.javascript.JSObject;

public class Api {
    private String divisa_value;
    private String converter_de;
    private String converter_a;

    // 5JMfPyRsEXnSHyueSZ91Ig7sQwuBI3Ef API enchange

    public void CallApi() {
    
        try {
            HttpClient httpClient = HttpClient.newHttpClient(); // Crea una instancia de HttpClient
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + this.converter_de + "/"+ this.converter_a + ".json"))
                    .build();

            // Envía la solicitud a la API y lee la respuesta
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Imprime la respuesta de la API
            //System.out.println(httpResponse.body());

            setDivisa_value(httpResponse.body());
            //divisa_value = httpResponse.body();
        } catch (Exception e) {
            System.out.println("Error al llamar a la API: " + e.getMessage());
        }
    }

    
    public String setDivisa_value(String divisa_value) {
        this.divisa_value = divisa_value;
        return divisa_value;
    }


    public String getDivisa_value() {
        return divisa_value;
    }

    public String getConverter_de() {
        return converter_de;
    }

    public void setConverter_de(String converter_de) {
        this.converter_de = converter_de;
    }

    public String getConverter_a() {
        return converter_a;
    }

    public void setConverter_a(String converter_a) {
        this.converter_a = converter_a;
    }


    
}
