package projeto.pros.classes;

/**
 * Created by Luiz on 09/04/2017.
 */

public class EquipamentoSemPatrimonio {
    private int id;
    private String nome;
    private TipoEquipamento tipoEquipamento;

    public EquipamentoSemPatrimonio() {
    }

    public EquipamentoSemPatrimonio(int id, String nome, TipoEquipamento tipoEquipamento) {
        this.id = id;
        this.nome = nome;
        this.tipoEquipamento = tipoEquipamento;
    }

    public EquipamentoSemPatrimonio(String nome, TipoEquipamento tipoEquipamento) {
        this.nome = nome;
        this.tipoEquipamento = tipoEquipamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
