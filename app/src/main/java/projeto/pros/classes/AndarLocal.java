package projeto.pros.classes;

public class AndarLocal {

    int id;
    BlocoLocal blocoLocal;
    String nome;


    // constructors
    public AndarLocal() {
    }


    public AndarLocal(int id, BlocoLocal blocoLocal, String nome) {
        this.id = id;
        this.blocoLocal = blocoLocal;
        this.nome = nome;
    }

    public AndarLocal(BlocoLocal blocoLocal, String nome) {
        this.blocoLocal = blocoLocal;
        this.nome = nome;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setBlocoLocal(BlocoLocal blocoLocal) {
        this.blocoLocal = blocoLocal;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    // getters
    public long getId() {
        return this.id;
    }


    public BlocoLocal getBlocoLocal() {
        return this.blocoLocal;
    }

    public String getNome() {
        return this.nome;
    }


    @Override
    public String toString() {
        return this.nome;
    }
}