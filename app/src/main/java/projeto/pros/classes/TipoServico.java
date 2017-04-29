package projeto.pros.classes;

public class TipoServico {

    int id;
    Instituicao instituicao;
    String nome;
    boolean permiteAgendamento;

    // constructors
    public TipoServico() {
    }


    public TipoServico(int id, Instituicao instituicao, String nome, boolean permiteAgendamento) {
        this.id = id;
        this.instituicao = instituicao;
        this.nome = nome;
        this.permiteAgendamento = permiteAgendamento;
    }

    public TipoServico(Instituicao instituicao, String nome, boolean permiteAgendamento) {
        this.instituicao = instituicao;
        this.nome = nome;
        this.permiteAgendamento = permiteAgendamento;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPermiteAgendamento(boolean permiteAgendamento) {
        this.permiteAgendamento = permiteAgendamento;
    }


    // getters
    public long getId() {
        return this.id;
    }

    public Instituicao getInstituicao() {
        return this.instituicao;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean getPermiteAgendamento() {
        return this.permiteAgendamento;
    }
}