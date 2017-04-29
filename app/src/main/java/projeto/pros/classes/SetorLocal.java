package projeto.pros.classes;

public class SetorLocal {

    int id;
    AndarLocal andarLocal;
    String nome;

    // constructors
    public SetorLocal() {
    }


    public SetorLocal(int id, AndarLocal andarLocal, String nome) {
        this.id = id;
        this.andarLocal = andarLocal;
        this.nome = nome;
    }

    public SetorLocal(AndarLocal andarLocal, String nome) {
        this.andarLocal = andarLocal;
        this.nome = nome;
    }


    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setAndarLocal(AndarLocal andarLocal) {
        this.andarLocal = andarLocal;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    // getters
    public long getId() {
        return this.id;
    }


    public AndarLocal getAndarLocal() {
        return this.andarLocal;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}