
package projeto.pros;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.ref.WeakReference;
import java.util.List;

import projeto.pros.classes.EquipamentoSemPatrimonio;
import projeto.pros.classes.Instituicao;
import projeto.pros.classes.Local;
import projeto.pros.classes.TipoEquipamento;
import projeto.pros.classes.TipoServico;
import projeto.pros.sqlite.SQLiteModel;
import projeto.pros.utils.BrPhoneNumberFormatter;

public class NovoServico extends AppCompatActivity {

    SQLiteModel db;
    Spinner spinnerTipoServico;
    Spinner spinnerTipoEquipamento;
    AutoCompleteTextView autoCompleteEquipamento;
    AutoCompleteTextView autoCompleteLocalizacao;
    EditText telephone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_servico);

        db = new SQLiteModel(getApplicationContext());

        carregarTipoServico();
        carregarTipoEquipamento();
        carregarAcEquipamento();
        carregarAcLocalizacao();

        //Formatar telefone para padrão brasileiro
        telephone = (EditText) findViewById(R.id.txtTelefoneSolicitante);
        BrPhoneNumberFormatter addLineNumberFormatter = new BrPhoneNumberFormatter(new WeakReference<EditText>(telephone));
        telephone.addTextChangedListener(addLineNumberFormatter);


    }

    public void validarCarga(View v) {

        db.dropTables();

        Instituicao instituicao1 = db.getInstituicao(1);
        TipoServico tipoServico1 = db.getTipoServico(1);
        TipoEquipamento tipoEquipamento1 = db.getTipoEquipamento(1);


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Total inclusao");
        alert.setMessage(
                "Instituição 1:" + instituicao1.toString() + "\n"
                        + "Tipo Serviço 1:" + tipoServico1.toString() + "\n"
                        + "Tipo Equipamento 1:" + tipoEquipamento1.toString() + "\n"

        );

        alert.setPositiveButton("OK", null);
        alert.show();

        //db.dropTables();
    }

    public void carregarTipoServico() {
        Log.e("NovoServico", "carregarTipoServico");

        this.spinnerTipoServico = (Spinner) findViewById(R.id.spnTipoServico);
        List<TipoServico> tipoServicoList = db.getAllTipoServico();
        ArrayAdapter<TipoServico> tipoServicoArrayAdapter = new ArrayAdapter<TipoServico>(this, R.layout.spinner_item, tipoServicoList);


        tipoServicoArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        this.spinnerTipoServico.setAdapter(tipoServicoArrayAdapter);

    }

    public void carregarTipoEquipamento() {
        Log.e("NovoServico", "carregarTipoEquipamento");

        this.spinnerTipoEquipamento = (Spinner) findViewById(R.id.spnTipoEquipamento);
        List<TipoEquipamento> tipoEquipamentoList = db.getAllTipoEquipamento();
        ArrayAdapter<TipoEquipamento> tipoEquipamentoArrayAdapter = new ArrayAdapter<TipoEquipamento>(this, R.layout.spinner_item, tipoEquipamentoList);


        tipoEquipamentoArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        this.spinnerTipoEquipamento.setAdapter(tipoEquipamentoArrayAdapter);

    }

    public void carregarAcEquipamento() {
        Log.e("NovoServico", "carregarAcEquipamento");


        this.autoCompleteEquipamento = (AutoCompleteTextView) findViewById(R.id.txtAcEquipamento);
        List<EquipamentoSemPatrimonio> equipamentoSemPatrimonioList = db.getAllEquipamentoSemPatrimonio();
        ArrayAdapter<EquipamentoSemPatrimonio> equipamentoSemPatrimonioArrayAdapter = new ArrayAdapter<EquipamentoSemPatrimonio>(this, R.layout.spinner_item, equipamentoSemPatrimonioList);

        this.autoCompleteEquipamento.setThreshold(1);
        this.autoCompleteEquipamento.setAdapter(equipamentoSemPatrimonioArrayAdapter);


    }

    public void carregarAcLocalizacao() {
        Log.e("NovoServico", "carregarAcLocalizacao");


        this.autoCompleteLocalizacao = (AutoCompleteTextView) findViewById(R.id.txtAcLocalizacao);
        List<Local> localList = db.getAllLocal();
        ArrayAdapter<Local> localArrayAdapter = new ArrayAdapter<Local>(this, R.layout.spinner_dropdown, localList);

        this.autoCompleteLocalizacao.setThreshold(1);
        this.autoCompleteLocalizacao.setAdapter(localArrayAdapter);


    }

}
