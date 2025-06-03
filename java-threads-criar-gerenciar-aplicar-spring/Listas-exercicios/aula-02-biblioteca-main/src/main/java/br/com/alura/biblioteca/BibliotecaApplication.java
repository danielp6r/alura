package br.com.alura.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
2 - Vimos, em vídeo, como funciona a atualização com o Lock otimista, usando o @Version. Para confirmar esse fato, tente atualizar o título de um livro, utilizando o metodo PUT do controller. Veja se a versão foi atualizada, fazendo um select no banco.

Você pode usar: SELECT * FROM livros;

**Uma dica: ** para que o versionamento funcione corretamente, você precisa de realmente alterar o título passado no Postman. Caso contrário, a versão não será alterada.

3 - Teste o GET do controller e confirme: o lock optimistic altera a versão somente em casos de escrita no banco.

4 - Agora, na classe LivroRepository, troque o tipo de Lock de OPTIMISTIC para OPTMISTIC_FORCE_INCREMENT e repita o GET. Houveram alterações?

5 - Tente apagar o @Transactional do metodo de obter livro por id. O que acontece ao tentar obter o livro? Tente pensar no motivo pelo qual isso ocorre.

6 - Repita os testes para os locks READ e WRITE.

7 - Iremos testar os locks pessimistas. Para isso, você pode comentar o atributo versao. Inicie com o PESSIMISTIC_READ e tente executar requisições paralelas. Quais operações ele permite que sejam executadas?

8 - Repita o processo para PESSIMISTIC_WRITE. Quais são as exceções lançadas? São iguais às do lock otimista?

9 - Por fim, teste o PESSIMISTIC_FORCE_INCREMENT. Para isso, você precisará voltar com o atributo de versão. Veja como a versão é incrementada a cada atualização/leitura e depois tente fazer requisições paralelas. Como o OPTIMISTIC_FORCE_INCREMENT e o PESSIMISTIC_FORCE_INCREMENT se diferenciam?
 */

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
