package projeto.pros.classes;

public class Instituicao {

    int id;
    String nome;
    String dataInclusao;

    // constructors
    public Instituicao() {
    }

    public Instituicao(String nome) {
        this.nome = nome;

    }

    public Instituicao(int id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }


    public String getDataHoraInclusao() {
        return this.dataInclusao;
    }


    @Override
    public String toString() {
        return this.id + "|" + this.nome;
    }
}