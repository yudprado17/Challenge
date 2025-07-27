package conversormoneda; //

import java.io.IOException; //
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {

        Conversor.eleccionUserMenu();
    }



}