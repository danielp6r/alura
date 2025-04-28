package br.com.alura.screensound.service;
import org.springframework.web.client.RestTemplate;


public class ConsultaAPI {
    public String buscaArtista(String nomeArtista) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://musicbrainz.org/ws/2/artist/?query=" + nomeArtista.replace(" ", "%20") + "&fmt=json";
        return restTemplate.getForObject(url, String.class);
    }
}
