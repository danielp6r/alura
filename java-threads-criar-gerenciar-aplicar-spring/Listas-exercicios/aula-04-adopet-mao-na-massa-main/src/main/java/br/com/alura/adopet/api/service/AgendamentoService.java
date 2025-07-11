package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private PetService petService;

    @Autowired
    private EmailService emailService;

    //@Scheduled(cron = "0 20 16 * * *")
    @Scheduled(cron = "0 0 0 1 * *")
    public void AgendarRelatorioPets() {
        List<PetDto> pets = petService.buscarPetsDisponiveis();
        emailService.enviarEmail(
                "admin.email.com",
                "Pets não adotados",
                """
                        Segue a lista de pets disponíveis para adoção:
                        
                        %s
                        """.formatted(pets)
        );
        System.out.println(pets);
    }
}
