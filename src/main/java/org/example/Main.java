package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String urlStrBase;
        String baseConvert, targetConvert;
        int target = 1, amount = 1;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<String>> tiposDeCambio = new HashMap<>();
        tiposDeCambio.put(1, Arrays.asList("USD", "ARS"));
        tiposDeCambio.put(2, Arrays.asList("ARS", "USD"));
        tiposDeCambio.put(3, Arrays.asList("USD", "BRL"));
        tiposDeCambio.put(4, Arrays.asList("BRL", "USD"));
        tiposDeCambio.put(5, Arrays.asList("USD", "PEN"));
        tiposDeCambio.put(6, Arrays.asList("PEN", "USD"));

        HttpClient client = HttpClient.newHttpClient();

        while(true) {
            urlStrBase = "https://v6.exchangerate-api.com/v6/66c9ce606c70d9e305be93e7/pair/";

            menu();

            target = Integer.parseInt(scanner.nextLine());
            if (target == 7) {
                break;
            }
            urlStrBase += tiposDeCambio.get(target).get(0) + "/" + tiposDeCambio.get(target).get(1) + "/";
            System.out.println("Diga la cantidad a convertir =>>");
            amount = Integer.parseInt(scanner.nextLine());

            urlStrBase += amount;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStrBase))
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            ;

            ApiMoneda apiMoneda = gson.fromJson(response.body(), ApiMoneda.class);
            System.out.println(apiMoneda.getConversionResult());
        }

    }

    public static void menu() {
        System.out.println("""
                **********************************************
                Sea bienvenido/a al conversor de Monedas Jotita :D
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Sol peruano
                6) Sol peruano =>> Dólar
                7) Salir
                
                Elija la opción válida: 
                **********************************************
                """);
    }
}