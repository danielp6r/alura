package br.com.alura;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();

        for (Produto produto: produtos) {
            System.out.println(produto);
        }
//        Biblioteca de tradução não está funcionando, então essa parte será ignorada.

//        TraduzProdutoService traducaoService = new TraduzProdutoService();
//
//        for (Produto produto: produtos) {
//            traducaoService.traduzir(produto);
//            System.out.println(produto);
//        }

    }
}