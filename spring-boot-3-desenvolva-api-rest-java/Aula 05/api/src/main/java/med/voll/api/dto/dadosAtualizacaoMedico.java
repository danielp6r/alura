package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record dadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
