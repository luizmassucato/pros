package projeto.pros.classes;

public enum Perfil {
	 ADMINISTRADOR(1, "Administrador"), 
	 GESTOR(2, "Gestor"), 	
	 SOLICITANTE(3, "Solicitante"), 
	 ATENDIMENTO(4, "Atendimento"); 
 
 private int id; 
 private String nome;
 
private Perfil(int id, String nome) {
	this.id = id; 
	this.nome = nome;
	} 	
	
	public String getNomePerfil(){
	return this.nome;
	}
	
	public int getId(){
	return this.id;
	}
	
	
 }

