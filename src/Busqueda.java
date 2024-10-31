import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busqueda {

        public int busqueda(int opcionMoneda){
        String moneda = "";
                switch (opcionMoneda) {
                        case 1:
                                //De dólar a peso argentino
                                break; // Salir del switch
                        case 2:
                                //De peso argentio a Dólar
                                break; // Salir del switch
                        case 3:
                                //De dolar brasileño a dolar
                                break; // Salir del switch
                    case 4:
                        //De dolar a dolar brasileño
                        break; // Salir del switch
                    case 5:
                        //De dolar a dolar brasileño
                        break; // Salir del switch
                    case 6:
                        //De dolar
                        break; // Salir del switch
                        default:
                                // Bloque de código si no coincide con ningún caso
                                break; // Opcional
                }

            try {
                URI monedaUri = URI.create("https://v6.exchangerate-api.com/v6/be9ad7d12f096e5a5ec1a2de/latest/"+moneda);
                HttpClient cliente = HttpClient.newHttpClient();
                HttpRequest request= HttpRequest.newBuilder()
                        .uri(monedaUri)
                        .build();

                    HttpResponse<String> response = cliente
                        .send(request, HttpResponse.BodyHandlers.ofString());
                    return Integer.parseInt(String.valueOf(response));
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Ha ocurrido un error:"+e.getMessage());
            }


        };

}

