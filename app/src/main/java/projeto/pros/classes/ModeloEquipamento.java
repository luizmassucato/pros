package projeto.pros.classes;

public class ModeloEquipamento {
 
    int id;
	MarcaEquipamento marcaEquipamento;
	String nome;

 
    // constructors
    public ModeloEquipamento() {
    }
 
    
    public ModeloEquipamento(int id, MarcaEquipamento marcaEquipamento, String nome) {
        this.id = id;
		this.marcaEquipamento = marcaEquipamento;
		this.nome = nome;
    }

    public ModeloEquipamento(MarcaEquipamento marcaEquipamento, String nome) {
        this.marcaEquipamento = marcaEquipamento;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.marcaEquipamento.toString() + " " + this.nome;
    }


    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setMarcaEquipamento(MarcaEquipamento marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

	
    public void setNome(String nome) {
        this.nome = nome;
    }

 
 
    // getters
    public long getId() {
        return this.id;
    }
 

	
	 public MarcaEquipamento getMarcaEquipamento() {
        return this.marcaEquipamento;
    }
	
    public String getNome() {
        return this.nome;
    }
 
}