package conversormoneda;

import java.util.Scanner;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {

    private static final String API_KEY = "02a157f162c535b1e6d7ff8b";

    public static void eleccionUserMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        double cantidad;
        double resultado;
        String monedaOrigen = "";
        String monedaDestino = "";
        String urlApi;

        System.out.println("**************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda");
        System.out.println("**************************************************");

        while (opcion != 7) {
            System.out.println("\nElija una opción de conversión:");
            System.out.println("1. Dólar (USD) => Peso Argentino (ARS)");
            System.out.println("2. Peso Argentino (ARS) => Dólar (USD)");
            System.out.println("3. Dólar (USD) => Real Brasileño (BRL)");
            System.out.println("4. Real Brasileño (BRL) => Dólar (USD)");
            System.out.println("5. Dólar (USD) => Peso Colombiano (COP)");
            System.out.println("6. Peso Colombiano (COP) => Dólar (USD)");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                if (opcion >= 1 && opcion <= 6) {
                    System.out.print("Ingrese la cantidad a convertir: ");
                    cantidad = teclado.nextDouble();
                    teclado.nextLine();


                    switch (opcion) {
                        case 1: monedaOrigen = "USD"; monedaDestino = "ARS"; break;
                        case 2: monedaOrigen = "ARS"; monedaDestino = "USD"; break;
                        case 3: monedaOrigen = "USD"; monedaDestino = "BRL"; break;
                        case 4: monedaOrigen = "BRL"; monedaDestino = "USD"; break;
                        case 5: monedaOrigen = "USD"; monedaDestino = "COP"; break;
                        case 6: monedaOrigen = "COP"; monedaDestino = "USD"; break;
                    }

                    // Construir la URL de la API
                    urlApi = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;

                    // Llamar a obtenerTasa
                    double tasa = obtenerTasa(urlApi);
                    resultado = cantidad * tasa; // Realizar la conversión

                    System.out.printf("El valor de %.2f %s es igual a %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);

                } else if (opcion != 7) {
                    System.out.println("Opción inválida. Por favor, elija una opción del 1 al 7.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                teclado.nextLine();
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrió un error al conectar con la API o al procesar la solicitud: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
        System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta luego!");
        teclado.close();
    }


    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();


        if (response.statusCode() != 200) {
            throw new IOException("Error de la API: " + response.statusCode() + " - " + jsonResponse);
        }

        JsonElement elemento = JsonParser.parseString(jsonResponse);
        JsonObject objectRoot = elemento.getAsJsonObject();


        if (objectRoot.has("result") && objectRoot.get("result").getAsString().equals("error")) {
            throw new IOException("Error de la API: " + objectRoot.get("error-type").getAsString());
        }

        double tasa = objectRoot.get("conversion_rate").getAsDouble();
        return tasa;
    }
}