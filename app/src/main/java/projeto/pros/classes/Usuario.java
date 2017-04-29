package projeto.pros.classes;


public class Usuario {
 
    int id;
	Instituicao instituicao;
	String nome;
	Perfil perfil;
 
    // constructors
    public Usuario() {
    }
 
    
    public Usuario(int id, Instituicao instituicao, String nome, Perfil perfil) {
        this.id = id;
		this.instituicao = instituicao;
        this.nome = nome;
		this.perfil = perfil;
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

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
 
	public Perfil getPerfil(){
		return this.perfil;
	}
}