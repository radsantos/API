import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Intanciando objeto scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual nome do filme?");
        String busca = sc.nextLine();

        //String do enderço OMDB
        String endereco = "http://www.omdbapi.com/?t="+ busca + "&apikey=e00f0466";

        //Instanciando objeto client
        HttpClient client = HttpClient.newHttpClient();
        //Instanciando objeto request, passando o endreço da string na URI
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        //Obtendo a requisição do client e atribuido para o response no formato json
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
