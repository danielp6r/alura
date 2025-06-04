package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {

    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado enviador;

    // Agendamento no formato: segundo, minuto, hora, dia do mês, mês, dia da semana (6 campos — sem campo de ano)
    // * significa "qualquer valor" permitido no campo — ou seja, executa todos os dias, todos os meses, em qualquer dia da semana
    // Atenção: diaDoMes e diaDaSemana funcionam como condição OR —
    // a tarefa executa quando qualquer dos dois campos bater com a data atual
    // Exemplo para enviar todos os dias ao meio-dia de segunda a sexta:
    // (cron = "0 0 12 * * MON-FRI", zone = "America/Sao_Paulo")
    @Scheduled(cron = "0 0 15 * * *")
    public void envioDeEmailsAgendado() {
        var estoqueZerado = relatorioService.infoEstoque();
        var faturamentoObtido = relatorioService.faturamentoObtido();

        // Garante que ambas as tarefas assíncronas sejam concluídas antes de continuar
        CompletableFuture.allOf(estoqueZerado, faturamentoObtido).join();

        try {
            enviador.enviar(estoqueZerado.get(), faturamentoObtido.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread do agendamento: " + Thread.currentThread().getName());
    }
}
