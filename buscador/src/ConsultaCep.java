import com.google.gson.Gson;
import org.ietf.jgss.GSSContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep){
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

                HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço apartir desse CEP.");
        }
        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
