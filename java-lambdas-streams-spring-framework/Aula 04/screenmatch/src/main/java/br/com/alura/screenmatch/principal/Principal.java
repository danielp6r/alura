package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodeo;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    Scanner scanner = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a1547706";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca:");
        var nomeSerie = scanner.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas() ; i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i  + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodeo> episodeosTemporada = temporadas.get(i).episodeos();
            for (int j = 0; j < episodeosTemporada.size(); j++) {
                System.out.println(episodeosTemporada.get(j).titulo());
            }
        }

        temporadas.forEach(t -> t.episodeos().forEach(e -> System.out.println(e.titulo())));

//        List<String> nomes = Arrays.asList("fulano", "beltrano", "ciclano", "nome3", "nome4");
//
//        nomes.stream().sorted().limit(3).filter(n -> n.startsWith("b")).map(n -> n.toUpperCase())
//                .forEach(System.out::println);

        List<DadosEpisodeo> dadosEpisodeos = temporadas.stream()
                .flatMap(t -> t.episodeos().stream())
                .collect(Collectors.toList());

//        System.out.println("\nTop 10 episódios:");
//        dadosEpisodeos.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro filtro(N/A) " + e))
//                .sorted(Comparator.comparing(DadosEpisodeo::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordenação " + e))
//                .limit(10)
//                .peek(e -> System.out.println("Limite " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Map " + e))
//                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodeos().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("Digite o trecho do título: ");
        var trechoTitulo = scanner.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()) {
            System.out.println("Episódio encontrado: " + episodioBuscado.get().getTitulo());
            System.out.println("Temporada " + episodioBuscado.get().getTemporada());
        } else {
            System.out.println("Episódio não encontrado.");
        }
//
//        System.out.println("Filtrar episodios a partir de qual ano? ");
//        var ano = scanner.nextInt();
//        scanner.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1,1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                            "Episódio: " + e.getTitulo() +
//                            "Data de lançamento : " + e.getDataLancamento().format(formatador)
//                ));
        System.out.println("Avaliações por temporada:");
        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println(avaliacoesPorTemporada);

        System.out.println("Estatísticas:");
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println("Quantidade de eps avaliados: " + est.getCount());
        System.out.println("Media " + est.getAverage());
        System.out.println("Melhor ep: " + est.getMax());
        System.out.println("Pior ep: " + est.getMin());

    }

}
