package projeto.pros.classes;

public class BlocoLocal {

    int id;
    UnidadeLocal unidadeLocal;
    String nome;


    // constructors
    public BlocoLocal() {
    }


    public BlocoLocal(int id, UnidadeLocal unidadeLocal, String nome) {
        this.id = id;
        this.unidadeLocal = unidadeLocal;
        this.nome = nome;
    }

    public BlocoLocal(UnidadeLocal unidadeLocal, String nome) {
        this.unidadeLocal = unidadeLocal;
        this.nome = nome;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setUnidadeLocal(UnidadeLocal unidadeLocal) {
        this.unidadeLocal = unidadeLocal;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    // getters
    public long getId() {
        return this.id;
    }


    public UnidadeLocal getUnidadeLocal() {
        return this.unidadeLocal;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}