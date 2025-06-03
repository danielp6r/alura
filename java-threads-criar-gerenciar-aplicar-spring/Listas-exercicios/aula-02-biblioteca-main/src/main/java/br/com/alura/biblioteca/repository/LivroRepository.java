package br.com.alura.biblioteca.repository;

import br.com.alura.biblioteca.model.Livro;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    //nesse caso, com o OPTIMISTIC_FORCE_INCREMENT, tanto na atualização quanto na busca do livro, a versão é incrementada.
    //@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)

    //O Lock READ realmente funciona como o OPTIMISTIC e o WRITE funciona como o OPTIMISTIC_FORCE_INCREMENT.
    //@Lock(LockModeType.WRITE)
    //@Lock(LockModeType.READ)

    //O PESSIMISTIC_READ permite que leituras (buscas no banco de dados) sejam executadas paralelamente, mas escritas
    //(atualização do título) não podem ser feitas simultaneamente. Ao tentar atualizar o registro ao mesmo tempo,
    // obtemos a exceção: MySQLTransactionRollbackException.
    //@Lock(LockModeType.PESSIMISTIC_READ)

    //Nenhuma exceção foi lançada. Isso porque, como usamos o @Transactional, ele começa a transação e bloqueia o banco
    //de dados, esperando que ela finalize. Só depois que a operação termina, que outra requisição pode acessar o banco.
    //@Lock(LockModeType.PESSIMISTIC_WRITE)

    //No incremento da versão, eles são muito parecidos. O que muda é a forma de bloqueio:
    //um é otimista e usa a parte da versão, e outro é pessimista e bloqueia recursos.
    //@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)

    @Lock(LockModeType.OPTIMISTIC)
    Optional<Livro> findById(Long id);

}
