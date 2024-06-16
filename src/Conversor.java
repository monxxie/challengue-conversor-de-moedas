import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Conversor {
    private static final String url = "https://v6.exchangerate-api.com/v6/78d5e63d1ad414fd8feb0498/latest/USD";
    public static Map<String, Double> obterTaxasDeConversao() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return gson.fromJson(conversionRates, Map.class);
    }

    public static double converterMoedas(double valor, String moeda1, String moeda2) throws IOException, InterruptedException {
        Map<String, Double> taxasDeConversao = obterTaxasDeConversao();
        double taxas1 = taxasDeConversao.get(moeda1);
        double taxas2 = taxasDeConversao.get(moeda2);
        double valorFinal = (valor / taxas1) * taxas2;
        return valorFinal;
    }
}