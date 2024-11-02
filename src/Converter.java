import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Converter {
    public Currency convertCoin (String fromCoin, String toCoin, int amount){
        String apiKey = "be9ad7d12f096e5a5ec1a2de";
        URI monedaUri = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+fromCoin+"/"+toCoin+"/"+amount);
        HttpClient cliente = HttpClient.newHttpClient();
        try {

            HttpRequest request= HttpRequest.newBuilder()
                    .uri(monedaUri)
                    .build();

            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

          return new Gson().fromJson(response.body(), Currency.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ha ocurrido un error:"+e.getMessage());
        }
    }
}
