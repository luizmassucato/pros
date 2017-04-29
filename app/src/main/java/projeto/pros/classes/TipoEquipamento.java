package projeto.pros.classes;

public class TipoEquipamento {

    int id;
    Instituicao instituicao;
    String nome;


    // constructors
    public TipoEquipamento() {
    }


    public TipoEquipamento(int id, Instituicao instituicao, String nome) {
        this.id = id;
        this.instituicao = instituicao;
        this.nome = nome;

    }

    public TipoEquipamento(Instituicao instituicao, String nome) {

        this.instituicao = instituicao;
        this.nome = nome;

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


    @Override
    public String toString() {
        return this.nome;
    }
}