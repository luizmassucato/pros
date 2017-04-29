package projeto.pros.classes;

public class Local {

    private int id;
    private SetorLocal setorLocal;
    private String nome;
    private String nomeCompletoLocal;


    // constructors
    public Local() {
    }


    public Local(int id, SetorLocal setorLocal, String nome) {
        this.id = id;
        this.setorLocal = setorLocal;
        this.nome = nome;
    }

    public Local(SetorLocal setorLocal, String nome) {
        this.setorLocal = setorLocal;
        this.nome = nome;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setSetorLocal(SetorLocal setorLocal) {
        this.setorLocal = setorLocal;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeCompletoLocal(String nomeCompletoLocal) {
        this.nomeCompletoLocal = nomeCompletoLocal;
    }


    // getters
    public long getId() {
        return this.id;
    }


    public SetorLocal getSetorLocal() {
        return this.setorLocal;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNomeCompletoLocal() {
        return this.nomeCompletoLocal;
    }

    @Override
    public String toString() {
        if (nomeCompletoLocal == null) nomeCompletoLocal = nome;

        return this.nomeCompletoLocal;
    }

}