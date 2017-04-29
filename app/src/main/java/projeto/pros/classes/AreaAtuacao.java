package projeto.pros.classes;
 
public class AreaAtuacao {
 
    int id;
	int idInstituicao;
	String nome;
	boolean ativo;
 
    // constructors
    public AreaAtuacao() {
    }
 
    
    public AreaAtuacao(int id, int idInstituicao, String nome, boolean ativo) {
        this.id = id;
		this.idInstituicao = idInstituicao;
        this.nome = nome;
		this.ativo = ativo;
    }
 
    // setters
    public void setId(int id) {
        this.id = id;
    }
	
	public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
	
	public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

	
 
 
    // getters
    public long getId() {
        return this.id;
    }

    public long getIdInstituicao() {
        return this.idInstituicao;
    }
	
    public String getNome() {
        return this.nome;
    }
	
	public boolean getAtivo() {
        return this.ativo;
    }
}