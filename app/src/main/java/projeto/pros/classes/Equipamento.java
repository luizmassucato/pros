package projeto.pros.classes;

public class Equipamento {

    int id;
    int idModeloEquipamento;
    String codigoPatrimonio;
    TipoEquipamento tipoEquipamento;

    // constructors
    public Equipamento() {
    }


    public Equipamento(int id, int idModeloEquipamento, String codigoPatrimonio, TipoEquipamento tipoEquipamento) {
        this.id = id;
        this.idModeloEquipamento = idModeloEquipamento;
        this.codigoPatrimonio = codigoPatrimonio;
        this.tipoEquipamento = tipoEquipamento;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }


    public void setidModeloEquipamento(int idModeloEquipamento) {
        this.idModeloEquipamento = idModeloEquipamento;
    }


    public void setcodigoPatrimonio(String codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;

    }


    // getters
    public long getId() {
        return this.id;
    }

    public long getidModeloEquipamento() {
        return this.idModeloEquipamento;
    }

    public String getcodigoPatrimonio() {
        return this.codigoPatrimonio;
    }

    public TipoEquipamento getTipoEquipamento() {
        return this.tipoEquipamento;
    }

}