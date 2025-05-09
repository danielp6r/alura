package med.voll.api.model;

public record DadosListagemMedicoDTO(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
