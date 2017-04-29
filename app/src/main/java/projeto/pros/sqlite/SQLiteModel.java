package projeto.pros.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import projeto.pros.classes.AndarLocal;
import projeto.pros.classes.BlocoLocal;
import projeto.pros.classes.EquipamentoSemPatrimonio;
import projeto.pros.classes.Instituicao;
import projeto.pros.classes.Local;
import projeto.pros.classes.MarcaEquipamento;
import projeto.pros.classes.ModeloEquipamento;
import projeto.pros.classes.SetorLocal;
import projeto.pros.classes.TipoEquipamento;
import projeto.pros.classes.TipoServico;
import projeto.pros.classes.UnidadeLocal;

public class SQLiteModel extends SQLiteOpenHelper {

    SQLiteDatabase db;

    // LOG
    private static final String LOG = "SQLiteDatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "prosdb";

    // Tables names
    private static final String TABLE_INSTITUICAO = "instituicao";
    private static final String TABLE_TIPOSERVICO = "tipoServico";
    private static final String TABLE_USUARIO = "usuario";
    private static final String TABLE_AREAATUACAO = "areaAtuacao";
    private static final String TABLE_MARCAEQUIPAMENTO = "marcaEquipamento";
    private static final String TABLE_MODELOEQUIPAMENTO = "modeloEquipamento";
    private static final String TABLE_EQUIPAMENTO = "equipamento";
    private static final String TABLE_EQUIPAMENTOSEMPATRIMONIO = "equipamentoSemPatrimonio";
    private static final String TABLE_TIPOEQUIPAMENTO = "tipoEquipamento";
    private static final String TABLE_AREAATUACAO_TIPOEQUIPAMENTO = "areaAtuacao_tipoEquipamento";
    private static final String TABLE_UNIDADELOCAL = "unidadeLocal";
    private static final String TABLE_BLOCOLOCAL = "blocoLocal";
    private static final String TABLE_ANDARLOCAL = "andarLocal";
    private static final String TABLE_SETORLOCAL = "setorLocal";
    private static final String TABLE_LOCAL = "local";


    // Column names
    private static final String KEY_CODIGOPATRIMONIO = "codigoPatrimonio";
    private static final String KEY_DTTINCLUSAO = "dtt_inclusao";
    private static final String KEY_DTTATUALIZACAO = "dtt_atualizacao";
    private static final String KEY_ICPERMITEAGENDAMENTO = "ic_permiteAgendamento";
    private static final String KEY_ICATIVO = "icativo";
    private static final String KEY_ID = "id";
    private static final String KEY_IDANDARLOCAL = "id_andarLocal";
    private static final String KEY_IDAREAATUACAO = "id_areaAtuacao";
    private static final String KEY_IDBLOCOLOCAL = "id_blocoLocal";
    private static final String KEY_IDINSTITUICAO = "id_instituicao";
    private static final String KEY_IDMARCAEQUIPAMENTO = "id_marcaEquipamento";
    private static final String KEY_IDMODELOEQUIPAMENTO = "id_modeloEquipamento";
    private static final String KEY_IDTIPOEQUIPAMENTO = "id_tipoEquipamento";
    private static final String KEY_IDPERFIL = "id_perfil";
    private static final String KEY_IDSETORLOCAL = "id_setorLocal";
    private static final String KEY_IDUNIDADELOCAL = "id_unidadeLocal";
    private static final String KEY_IDUSUARIOATUALIZACAO = "id_usuario_atualizacao";
    private static final String KEY_IDUSUARIOINCLUSAO = "id_usuario_inclusao";
    private static final String KEY_NOME = "nome";


    // Table Create Statements
    // Instituicao table create statement
    private static final String CREATE_TABLE_INSTITUICAO = "CREATE TABLE " + TABLE_INSTITUICAO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_NOME + " TEXT," +
            KEY_DTTINCLUSAO + " DATETIME" +
            ")";

    // TipoServico table create statement
    private static final String CREATE_TABLE_TIPOSERVICO = "CREATE TABLE " + TABLE_TIPOSERVICO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + " INTEGER, " +
            KEY_NOME + " TEXT," +
            KEY_ICPERMITEAGENDAMENTO + " BOOLEAN" +
            ")";

    // Usuario table create statement
    private static final String CREATE_TABLE_USUARIO = "CREATE TABLE " + TABLE_USUARIO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + " INTEGER, " +
            KEY_NOME + " TEXT," +
            KEY_IDPERFIL + " INTEGER" +
            ")";

    // Area atuacao table create statement
    private static final String CREATE_TABLE_AREATUACAO = "CREATE TABLE " + TABLE_AREAATUACAO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + "INTEGER, " +
            KEY_NOME + " TEXT," +
            KEY_ICATIVO + " BOOLEAN, " +
            KEY_IDUSUARIOINCLUSAO + " INTEGER," +
            KEY_DTTINCLUSAO + " DATETIME, " +
            KEY_IDUSUARIOATUALIZACAO + " INTEGER," +
            KEY_DTTATUALIZACAO + " DATETIME " +
            ")";

    // MarcaEquipamento table create statement
    private static final String CREATE_TABLE_MARCAEQUIPAMENTO = "CREATE TABLE " + TABLE_MARCAEQUIPAMENTO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // ModeloEquipamento table create statement
    private static final String CREATE_TABLE_MODELOEQUIPAMENTO = "CREATE TABLE " + TABLE_MODELOEQUIPAMENTO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDMARCAEQUIPAMENTO + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // Equipamento table create statement
    private static final String CREATE_TABLE_EQUIPAMENTO = "CREATE TABLE " + TABLE_EQUIPAMENTO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDMODELOEQUIPAMENTO + " INTEGER, " +
            KEY_CODIGOPATRIMONIO + " TEXT," +
            KEY_IDTIPOEQUIPAMENTO + " INTEGER " +
            ")";

    // EquipamentoSemPatrimonio table create statement
    private static final String CREATE_TABLE_EQUIPAMENTOSEMPATRIMONIO = "CREATE TABLE " + TABLE_EQUIPAMENTOSEMPATRIMONIO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_NOME + " TEXT," +
            KEY_IDTIPOEQUIPAMENTO + " INTEGER " +
            ")";


    // TipoEquipamento table create statement
    private static final String CREATE_TABLE_TIPOEQUIPAMENTO = "CREATE TABLE " + TABLE_TIPOEQUIPAMENTO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // AreaAtuacao_TipoEquipamento table create statement
    private static final String CREATE_TABLE_AREAATUACAO_TIPOEQUIPAMENTO = "CREATE TABLE " + TABLE_AREAATUACAO_TIPOEQUIPAMENTO +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDAREAATUACAO + " INTEGER, " +
            KEY_IDTIPOEQUIPAMENTO + " INTEGER" +
            ")";

    // UnidadeLocal table create statement
    private static final String CREATE_TABLE_UNIDADELOCAL = "CREATE TABLE " + TABLE_UNIDADELOCAL +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDINSTITUICAO + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // BlocoLocal table create statement
    private static final String CREATE_TABLE_BLOCOLOCAL = "CREATE TABLE " + TABLE_BLOCOLOCAL +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDUNIDADELOCAL + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // AndarLocal table create statement
    private static final String CREATE_TABLE_ANDARLOCAL = "CREATE TABLE " + TABLE_ANDARLOCAL +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDBLOCOLOCAL + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // Setor   Local table create statement
    private static final String CREATE_TABLE_SETORLOCAL = "CREATE TABLE " + TABLE_SETORLOCAL +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDANDARLOCAL + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // Local table create statement
    private static final String CREATE_TABLE_LOCAL = "CREATE TABLE " + TABLE_LOCAL +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IDSETORLOCAL + " INTEGER, " +
            KEY_NOME + " TEXT" +
            ")";

    // ***************************************************************************************
    //Métodos instituicao
    // ***************************************************************************************
    public long insertInstituicao(Instituicao instituicao) {

        Log.e(LOG, "insertInstituicao");
        //SQLiteDatabase db = this.getWritableDatabase();


        String dataInclusao = getDateTime();

        ContentValues values = new ContentValues();
        values.put(KEY_NOME, instituicao.getNome());
        values.put(KEY_DTTINCLUSAO, dataInclusao);

        // insert row
        long result = db.insert(TABLE_INSTITUICAO, null, values);
        instituicao.setId((int) result);
        instituicao.setDataInclusao(dataInclusao);

        return result;
    }

    public int getInstituicaoCount() {
        String countQuery = "SELECT  * FROM " + TABLE_INSTITUICAO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }


    public Instituicao getInstituicao(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_INSTITUICAO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        Instituicao instituicao = new Instituicao();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            instituicao.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            instituicao.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            instituicao.setDataInclusao(c.getString(c.getColumnIndex(KEY_DTTINCLUSAO)));

        } finally {
            if (c != null)
                c.close();
        }

        return instituicao;
    }


    // ***************************************************************************************
    //Métodos tipoServico
    // ***************************************************************************************
    public long insertTipoServico(TipoServico tipoServico) {

        Log.e("insertTipoServico", "entrou");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDINSTITUICAO, tipoServico.getInstituicao().getId());
        values.put(KEY_NOME, tipoServico.getNome());
        values.put(KEY_ICPERMITEAGENDAMENTO, tipoServico.getPermiteAgendamento());

        // insert row
        long result = db.insert(TABLE_TIPOSERVICO, null, values);
        tipoServico.setId((int) result);

        return result;
    }


    public TipoServico getTipoServico(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TIPOSERVICO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        TipoServico tipoServico = new TipoServico();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            tipoServico.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            tipoServico.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            tipoServico.setPermiteAgendamento(c.getInt(c.getColumnIndex(KEY_ICPERMITEAGENDAMENTO)) > 0);
            tipoServico.setInstituicao(getInstituicao(c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO))));

        } finally {
            if (c != null)
                c.close();
        }

        return tipoServico;
    }

    public List<TipoServico> getAllTipoServico() {
        List<TipoServico> tipoServicoList = new ArrayList<TipoServico>();
        String selectQuery = "SELECT  * FROM " + TABLE_TIPOSERVICO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    TipoServico tipoServico = new TipoServico();


                    tipoServico.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    tipoServico.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    tipoServico.setPermiteAgendamento(c.getInt(c.getColumnIndex(KEY_ICPERMITEAGENDAMENTO)) > 0);
                    tipoServico.setInstituicao(getInstituicao((c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO)))));

                    tipoServicoList.add(tipoServico);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }
        db.close();
        return tipoServicoList;
    }

    // ***************************************************************************************
    //Métodos tipoEquipamento
    // ***************************************************************************************
    public long insertTipoEquipamento(TipoEquipamento tipoEquipamento) {

        Log.e("insertTipoEquipamento", "entrou");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDINSTITUICAO, tipoEquipamento.getInstituicao().getId());
        values.put(KEY_NOME, tipoEquipamento.getNome());

        // insert row
        long result = db.insert(TABLE_TIPOEQUIPAMENTO, null, values);
        tipoEquipamento.setId((int) result);

        return result;
    }


    public TipoEquipamento getTipoEquipamento(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TIPOEQUIPAMENTO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        TipoEquipamento tipoEquipamento = new TipoEquipamento();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            tipoEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            tipoEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            tipoEquipamento.setInstituicao(getInstituicao(c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO))));

        } finally {
            if (c != null)
                c.close();
        }

        return tipoEquipamento;
    }

    public List<TipoEquipamento> getAllTipoEquipamento() {
        List<TipoEquipamento> tipoEquipamentoList = new ArrayList<TipoEquipamento>();
        String selectQuery = "SELECT  * FROM " + TABLE_TIPOEQUIPAMENTO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    TipoEquipamento tipoEquipamento = new TipoEquipamento();


                    tipoEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    tipoEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    tipoEquipamento.setInstituicao(getInstituicao((c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO)))));

                    tipoEquipamentoList.add(tipoEquipamento);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return tipoEquipamentoList;
    }

    // ***************************************************************************************
    //Métodos marcaEquipamento
    // ***************************************************************************************
    public long insertMarcaEquipamento(MarcaEquipamento marcaEquipamento) {

        Log.e("insertMarcaEquipamento", "entrou");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDINSTITUICAO, marcaEquipamento.getInstituicao().getId());
        values.put(KEY_NOME, marcaEquipamento.getNome());

        // insert row
        long result = db.insert(TABLE_MARCAEQUIPAMENTO, null, values);
        marcaEquipamento.setId((int) result);

        return result;
    }


    public MarcaEquipamento getMarcaEquipamento(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_MARCAEQUIPAMENTO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        MarcaEquipamento marcaEquipamento = new MarcaEquipamento();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            marcaEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            marcaEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            marcaEquipamento.setInstituicao(getInstituicao(c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO))));

        } finally {
            if (c != null)
                c.close();
        }

        return marcaEquipamento;
    }

    public List<MarcaEquipamento> getAllMarcaEquipamento() {
        List<MarcaEquipamento> marcaEquipamentoList = new ArrayList<MarcaEquipamento>();
        String selectQuery = "SELECT  * FROM " + TABLE_MARCAEQUIPAMENTO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    MarcaEquipamento marcaEquipamento = new MarcaEquipamento();


                    marcaEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    marcaEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    marcaEquipamento.setInstituicao(getInstituicao((c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO)))));

                    marcaEquipamentoList.add(marcaEquipamento);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return marcaEquipamentoList;
    }


    // ***************************************************************************************
    //Métodos modeloEquipamento
    // ***************************************************************************************
    public long insertModeloEquipamento(ModeloEquipamento modeloEquipamento) {

        Log.e("insertModeloEquipamento", "entrou");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDMARCAEQUIPAMENTO, modeloEquipamento.getMarcaEquipamento().getId());
        values.put(KEY_NOME, modeloEquipamento.getNome());

        // insert row
        long result = db.insert(TABLE_MODELOEQUIPAMENTO, null, values);
        modeloEquipamento.setId((int) result);

        return result;
    }


    public ModeloEquipamento getModeloEquipamento(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_MODELOEQUIPAMENTO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        ModeloEquipamento modeloEquipamento = new ModeloEquipamento();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            modeloEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            modeloEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            modeloEquipamento.setMarcaEquipamento(getMarcaEquipamento(c.getInt(c.getColumnIndex(KEY_IDMARCAEQUIPAMENTO))));

        } finally {
            if (c != null)
                c.close();
        }

        return modeloEquipamento;
    }

    public List<ModeloEquipamento> getAllModeloEquipamento() {
        List<ModeloEquipamento> modeloEquipamentoList = new ArrayList<ModeloEquipamento>();
        String selectQuery = "SELECT  * FROM " + TABLE_MODELOEQUIPAMENTO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    ModeloEquipamento modeloEquipamento = new ModeloEquipamento();


                    modeloEquipamento.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    modeloEquipamento.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    modeloEquipamento.setMarcaEquipamento(getMarcaEquipamento((c.getInt(c.getColumnIndex(KEY_IDMARCAEQUIPAMENTO)))));

                    modeloEquipamentoList.add(modeloEquipamento);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return modeloEquipamentoList;
    }


    // ***************************************************************************************
    //Métodos equipamentoSemPatrimonio
    // ***************************************************************************************
    public long insertEquipamentoSemPatrimonio(EquipamentoSemPatrimonio equipamentoSemPatrimonio) {

        Log.e("insertEquipamentoSemPat", "entrou");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDTIPOEQUIPAMENTO, equipamentoSemPatrimonio.getTipoEquipamento().getId());
        values.put(KEY_NOME, equipamentoSemPatrimonio.getNome());

        // insert row
        long result = db.insert(TABLE_EQUIPAMENTOSEMPATRIMONIO, null, values);
        equipamentoSemPatrimonio.setId((int) result);

        return result;
    }


    public EquipamentoSemPatrimonio getEquipamentoSemPatrimonio(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_EQUIPAMENTOSEMPATRIMONIO + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        EquipamentoSemPatrimonio equipamentoSemPatrimonio = new EquipamentoSemPatrimonio();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            equipamentoSemPatrimonio.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            equipamentoSemPatrimonio.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            equipamentoSemPatrimonio.setTipoEquipamento(getTipoEquipamento(c.getInt(c.getColumnIndex(KEY_IDTIPOEQUIPAMENTO))));

        } finally {
            if (c != null)
                c.close();
        }

        return equipamentoSemPatrimonio;
    }

    public List<EquipamentoSemPatrimonio> getAllEquipamentoSemPatrimonio() {
        List<EquipamentoSemPatrimonio> equipamentoSemPatrimonioList = new ArrayList<EquipamentoSemPatrimonio>();
        String selectQuery = "SELECT  * FROM " + TABLE_EQUIPAMENTOSEMPATRIMONIO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    EquipamentoSemPatrimonio equipamentoSemPatrimonio = new EquipamentoSemPatrimonio();


                    equipamentoSemPatrimonio.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    equipamentoSemPatrimonio.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    equipamentoSemPatrimonio.setTipoEquipamento(getTipoEquipamento((c.getInt(c.getColumnIndex(KEY_IDTIPOEQUIPAMENTO)))));

                    equipamentoSemPatrimonioList.add(equipamentoSemPatrimonio);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return equipamentoSemPatrimonioList;
    }


    // ***************************************************************************************
    //Métodos unidadeLocal
    // ***************************************************************************************
    public long insertUnidadeLocal(UnidadeLocal unidadeLocal) {

        Log.e(LOG, "insertUnidadeLocal");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDINSTITUICAO, unidadeLocal.getInstituicao().getId());
        values.put(KEY_NOME, unidadeLocal.getNome());

        // insert row
        long result = db.insert(TABLE_UNIDADELOCAL, null, values);
        unidadeLocal.setId((int) result);

        return result;
    }


    public UnidadeLocal getUnidadeLocal(long id) {
        Log.e(LOG, "getUnidadeLocal");

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_UNIDADELOCAL + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        UnidadeLocal unidadeLocal = new UnidadeLocal();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            unidadeLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            unidadeLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            unidadeLocal.setInstituicao(getInstituicao(c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO))));

        } finally {
            if (c != null)
                c.close();
        }

        return unidadeLocal;
    }

    public List<UnidadeLocal> getAllUnidadeLocal() {
        Log.e(LOG, "getAllUnidadeLocal");
        List<UnidadeLocal> unidadeLocalList = new ArrayList<UnidadeLocal>();
        String selectQuery = "SELECT  * FROM " + TABLE_UNIDADELOCAL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    UnidadeLocal unidadeLocal = new UnidadeLocal();


                    unidadeLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    unidadeLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    unidadeLocal.setInstituicao(getInstituicao((c.getInt(c.getColumnIndex(KEY_IDINSTITUICAO)))));

                    unidadeLocalList.add(unidadeLocal);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return unidadeLocalList;
    }

    // ***************************************************************************************
    //Métodos blocoLocal
    // ***************************************************************************************
    public long insertBlocoLocal(BlocoLocal blocoLocal) {

        Log.e(LOG, "insertBlocoLocal");
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDUNIDADELOCAL, blocoLocal.getUnidadeLocal().getId());
        values.put(KEY_NOME, blocoLocal.getNome());

        // insert row
        long result = db.insert(TABLE_BLOCOLOCAL, null, values);
        blocoLocal.setId((int) result);

        return result;
    }


    public BlocoLocal getBlocoLocal(long id) {
        Log.e(LOG, "getBlocoLocal");
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_BLOCOLOCAL + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        BlocoLocal blocoLocal = new BlocoLocal();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            blocoLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            blocoLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            blocoLocal.setUnidadeLocal(getUnidadeLocal(c.getInt(c.getColumnIndex(KEY_IDUNIDADELOCAL))));

        } finally {
            if (c != null)
                c.close();
        }

        return blocoLocal;
    }

    public List<BlocoLocal> getAllBlocoLocal() {
        Log.e(LOG, "getAllBlocoLocal");

        List<BlocoLocal> blocoLocalList = new ArrayList<BlocoLocal>();
        String selectQuery = "SELECT  * FROM " + TABLE_BLOCOLOCAL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    BlocoLocal blocoLocal = new BlocoLocal();


                    blocoLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    blocoLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    blocoLocal.setUnidadeLocal(getUnidadeLocal((c.getInt(c.getColumnIndex(KEY_IDUNIDADELOCAL)))));

                    blocoLocalList.add(blocoLocal);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return blocoLocalList;
    }

    // ***************************************************************************************
    //Métodos andarLocal
    // ***************************************************************************************
    public long insertAndarLocal(AndarLocal andarLocal) {
        Log.e(LOG, "insertAndarLocal");

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDBLOCOLOCAL, andarLocal.getBlocoLocal().getId());
        values.put(KEY_NOME, andarLocal.getNome());

        // insert row
        long result = db.insert(TABLE_ANDARLOCAL, null, values);
        andarLocal.setId((int) result);

        return result;
    }


    public AndarLocal getAndarLocal(long id) {
        Log.e(LOG, "getAndarLocal");
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ANDARLOCAL + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        AndarLocal andarLocal = new AndarLocal();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            andarLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            andarLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            andarLocal.setBlocoLocal(getBlocoLocal(c.getInt(c.getColumnIndex(KEY_IDBLOCOLOCAL))));

        } finally {
            if (c != null)
                c.close();
        }

        return andarLocal;
    }

    public List<AndarLocal> getAllAndarLocal() {
        Log.e(LOG, "getAllAndarLocal");

        List<AndarLocal> andarLocalList = new ArrayList<AndarLocal>();
        String selectQuery = "SELECT  * FROM " + TABLE_ANDARLOCAL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    AndarLocal andarLocal = new AndarLocal();


                    andarLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    andarLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    andarLocal.setBlocoLocal(getBlocoLocal((c.getInt(c.getColumnIndex(KEY_IDBLOCOLOCAL)))));

                    andarLocalList.add(andarLocal);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return andarLocalList;
    }

    // ***************************************************************************************
    //Métodos setorLocal
    // ***************************************************************************************
    public long insertSetorLocal(SetorLocal setorLocal) {
        Log.e(LOG, "insertSetorLocal");

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDANDARLOCAL, setorLocal.getAndarLocal().getId());
        values.put(KEY_NOME, setorLocal.getNome());

        // insert row
        long result = db.insert(TABLE_SETORLOCAL, null, values);
        setorLocal.setId((int) result);

        return result;
    }


    public SetorLocal getSetorLocal(long id) {
        Log.e(LOG, "getSetorLocal");
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SETORLOCAL + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        SetorLocal setorLocal = new SetorLocal();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            setorLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            setorLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            setorLocal.setAndarLocal(getAndarLocal(c.getInt(c.getColumnIndex(KEY_IDANDARLOCAL))));

        } finally {
            if (c != null)
                c.close();
        }

        return setorLocal;
    }

    public List<SetorLocal> getAllSetorLocal() {
        Log.e(LOG, "getAllSetorLocal");

        List<SetorLocal> setorLocalList = new ArrayList<SetorLocal>();
        String selectQuery = "SELECT  * FROM " + TABLE_SETORLOCAL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    SetorLocal setorLocal = new SetorLocal();


                    setorLocal.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    setorLocal.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
                    setorLocal.setAndarLocal(getAndarLocal((c.getInt(c.getColumnIndex(KEY_IDANDARLOCAL)))));

                    setorLocalList.add(setorLocal);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return setorLocalList;
    }

    // ***************************************************************************************
    //Métodos local
    // ***************************************************************************************
    public long insertLocal(Local local) {
        Log.e(LOG, "insertLocal");

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_IDSETORLOCAL, local.getSetorLocal().getId());
        values.put(KEY_NOME, local.getNome());

        // insert row
        long result = db.insert(TABLE_LOCAL, null, values);
        local.setId((int) result);

        return result;
    }


    public Local getLocal(long id) {
        Log.e(LOG, "getLocal");
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_LOCAL + " WHERE "
                + KEY_ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = null;
        Local local = new Local();

        try {
            c = db.rawQuery(selectQuery, null);
            if (c != null)
                c.moveToFirst();

            local.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            local.setNome((c.getString(c.getColumnIndex(KEY_NOME))));
            local.setSetorLocal(getSetorLocal(c.getInt(c.getColumnIndex(KEY_IDSETORLOCAL))));

        } finally {
            if (c != null)
                c.close();
        }

        return local;
    }

    public List<Local> getAllLocal() {
        Log.e(LOG, "getAllLocal");

        List<Local> localList = new ArrayList<Local>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOCAL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String nomeLocal = null;

        try {
            c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    Local local = new Local();


                    local.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                    local.setSetorLocal(getSetorLocal((c.getInt(c.getColumnIndex(KEY_IDSETORLOCAL)))));

                    nomeLocal = (c.getString(c.getColumnIndex(KEY_NOME)));
                    local.setNomeCompletoLocal(local.getSetorLocal().getAndarLocal().toString() +
                            "| " + local.getSetorLocal().toString() +
                            "| " + nomeLocal);


                    localList.add(local);
                } while (c.moveToNext());
            }

        } finally {
            if (c != null)
                c.close();
        }

        return localList;
    }


    // ***************************************************************************************
    // MÉTODOS
    // ***************************************************************************************


    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    // ***************************************************************************************
    // CONSTRUTORES
    // ***************************************************************************************


    public SQLiteModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;
        Log.e(LOG, "onCreate");
        // creating required tables
        db.execSQL(CREATE_TABLE_INSTITUICAO);
        db.execSQL(CREATE_TABLE_TIPOSERVICO);

        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_AREATUACAO);
        db.execSQL(CREATE_TABLE_MARCAEQUIPAMENTO);
        db.execSQL(CREATE_TABLE_MODELOEQUIPAMENTO);
        db.execSQL(CREATE_TABLE_EQUIPAMENTO);
        db.execSQL(CREATE_TABLE_EQUIPAMENTOSEMPATRIMONIO);
        db.execSQL(CREATE_TABLE_TIPOEQUIPAMENTO);
        db.execSQL(CREATE_TABLE_AREAATUACAO_TIPOEQUIPAMENTO);
        db.execSQL(CREATE_TABLE_UNIDADELOCAL);
        db.execSQL(CREATE_TABLE_BLOCOLOCAL);
        db.execSQL(CREATE_TABLE_ANDARLOCAL);
        db.execSQL(CREATE_TABLE_SETORLOCAL);
        db.execSQL(CREATE_TABLE_LOCAL);

        cargaInicial();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        Log.e("onUpgrade", "entrou");
        dropTables();


        // create new tables
        onCreate(db);


    }

    public void dropTables() {

        Log.e(LOG, "dropTables");

        SQLiteDatabase db = this.getReadableDatabase();


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSTITUICAO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIPOSERVICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREAATUACAO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARCAEQUIPAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODELOEQUIPAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPAMENTOSEMPATRIMONIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIPOEQUIPAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREAATUACAO_TIPOEQUIPAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIDADELOCAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BLOCOLOCAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANDARLOCAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETORLOCAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCAL);

        onCreate(db);
    }

    public void cargaInicial() {
        Log.e(LOG, "cargaInicial");

        //Carga inicial
        Instituicao instituicao = new Instituicao("Instituicão Plataforma Android");
        insertInstituicao(instituicao);

        //Carga TipoServico
        TipoServico tipoServicoCorretiva = new TipoServico(instituicao, "Corretiva", false);
        insertTipoServico(tipoServicoCorretiva);

        TipoServico tipoServicoPreventiva = new TipoServico(instituicao, "Preventiva", true);
        insertTipoServico(tipoServicoPreventiva);

        TipoServico tipoServicoInstalacao = new TipoServico(instituicao, "Instalacão", true);
        insertTipoServico(tipoServicoInstalacao);

        //Carga TipoServico
        //fake Selecione
        TipoEquipamento tipoEquipamento = new TipoEquipamento(instituicao, "Selecione");
        insertTipoEquipamento(tipoEquipamento);
        Log.e(LOG, "tipoEquipamento" + tipoEquipamento.toString());

        TipoEquipamento tipoEquipamento1 = new TipoEquipamento(instituicao, "Sensor Oximetria");
        insertTipoEquipamento(tipoEquipamento1);
        Log.e(LOG, "tipoEquipamento1" + tipoEquipamento1.toString());

        TipoEquipamento tipoEquipamento2 = new TipoEquipamento(instituicao, "Respirador");
        insertTipoEquipamento(tipoEquipamento2);
        Log.e(LOG, "tipoEquipamento2: " + tipoEquipamento2.toString());

        TipoEquipamento tipoEquipamento3 = new TipoEquipamento(instituicao, "Ventilador Pulmonar");
        insertTipoEquipamento(tipoEquipamento3);

        TipoEquipamento tipoEquipamento4 = new TipoEquipamento(instituicao, "Ar condicionado");
        insertTipoEquipamento(tipoEquipamento4);

        TipoEquipamento tipoEquipamento5 = new TipoEquipamento(instituicao, "Inst. Elétrica");
        insertTipoEquipamento(tipoEquipamento5);

        TipoEquipamento tipoEquipamento6 = new TipoEquipamento(instituicao, "Inst. Hidráulica");
        insertTipoEquipamento(tipoEquipamento6);

        TipoEquipamento tipoEquipamento7 = new TipoEquipamento(instituicao, "Telefonia");
        insertTipoEquipamento(tipoEquipamento7);

        TipoEquipamento tipoEquipamento8 = new TipoEquipamento(instituicao, "Cama Hospitalar");
        insertTipoEquipamento(tipoEquipamento8);

        TipoEquipamento tipoEquipamento9 = new TipoEquipamento(instituicao, "Eletrocardiograma");
        insertTipoEquipamento(tipoEquipamento9);

        TipoEquipamento tipoEquipamento10 = new TipoEquipamento(instituicao, "Monitor Paciente");
        insertTipoEquipamento(tipoEquipamento10);


        //Carga MarcaEquipamento
        MarcaEquipamento marcaEquipamento1 = new MarcaEquipamento(instituicao, "DIXTAL");
        insertMarcaEquipamento(marcaEquipamento1);
        Log.e(LOG, "marcaEquipamento1" + marcaEquipamento1.toString());

        //Carga ModeloEquipamento
        ModeloEquipamento modeloEquipamento1 = new ModeloEquipamento(marcaEquipamento1, "DX 2022");
        insertModeloEquipamento(modeloEquipamento1);
        Log.e(LOG, "modeloEquipamento1" + modeloEquipamento1.toString());


        //Carga EquipamentoSemPatrimonio
        EquipamentoSemPatrimonio equipamentoSemPatrimonio1 = new EquipamentoSemPatrimonio("Sensor Oximetro de dedo", tipoEquipamento1);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio1);
        Log.e(LOG, "equipamentoSemPatrimonio1" + equipamentoSemPatrimonio1.toString());

        EquipamentoSemPatrimonio equipamentoSemPatrimonio2 = new EquipamentoSemPatrimonio("Tomada", tipoEquipamento5);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio2);
        Log.e(LOG, "equipamentoSemPatrimonio2" + equipamentoSemPatrimonio2.toString());

        EquipamentoSemPatrimonio equipamentoSemPatrimonio3 = new EquipamentoSemPatrimonio("Lâmpada", tipoEquipamento5);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio3);
        Log.e(LOG, "equipamentoSemPatrimonio3" + equipamentoSemPatrimonio3.toString());

        EquipamentoSemPatrimonio equipamentoSemPatrimonio4 = new EquipamentoSemPatrimonio("Interruptor", tipoEquipamento5);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio4);
        Log.e(LOG, "equipamentoSemPatrimonio4" + equipamentoSemPatrimonio4.toString());

        EquipamentoSemPatrimonio equipamentoSemPatrimonio5 = new EquipamentoSemPatrimonio("Quadro de força", tipoEquipamento5);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio5);
        Log.e(LOG, "equipamentoSemPatrimonio5" + equipamentoSemPatrimonio5.toString());

        EquipamentoSemPatrimonio equipamentoSemPatrimonio6 = new EquipamentoSemPatrimonio("Luminária", tipoEquipamento6);
        insertEquipamentoSemPatrimonio(equipamentoSemPatrimonio6);
        Log.e(LOG, "equipamentoSemPatrimonio6" + equipamentoSemPatrimonio6.toString());

        UnidadeLocal unidadeLocal1 = new UnidadeLocal(instituicao, "Sede");
        insertUnidadeLocal(unidadeLocal1);
        Log.e(LOG, "unidadeLocal1" + unidadeLocal1.toString());

        BlocoLocal blocoLocal1 = new BlocoLocal(unidadeLocal1, "Bloco A");
        insertBlocoLocal(blocoLocal1);
        Log.e(LOG, "blocoLocal1" + blocoLocal1.toString());

        AndarLocal andarLocal1 = new AndarLocal(blocoLocal1, "Térreo");
        insertAndarLocal(andarLocal1);
        Log.e(LOG, "andarLocal1" + andarLocal1.toString());

        SetorLocal setorLocal1 = new SetorLocal(andarLocal1, "Pronto Socorro");
        insertSetorLocal(setorLocal1);
        Log.e(LOG, "setorLocal1" + setorLocal1.toString());

        Local local1 = new Local(setorLocal1, "Leitos A");
        insertLocal(local1);
        Log.e(LOG, "insertLocal" + local1.toString());

        Local local2 = new Local(setorLocal1, "Isolamento");
        insertLocal(local2);
        Log.e(LOG, "insertLocal" + local1.toString());


        AndarLocal andarLocal2 = new AndarLocal(blocoLocal1, "1o Andar");
        insertAndarLocal(andarLocal2);
        Log.e(LOG, "andarLocal2" + andarLocal2.toString());

        SetorLocal setorLocal2 = new SetorLocal(andarLocal2, "Internação");
        insertSetorLocal(setorLocal2);
        Log.e(LOG, "setorLocal2" + setorLocal2.toString());

        Local local3 = new Local(setorLocal2, "Quarto 101");
        insertLocal(local3);
        Log.e(LOG, "insertLocal" + local3.toString());

        Local local4 = new Local(setorLocal2, "Quarto 102");
        insertLocal(local4);

        SetorLocal setorLocal3 = new SetorLocal(andarLocal2, "UTI");
        insertSetorLocal(setorLocal3);

        Local local5 = new Local(setorLocal3, "Sala 1");
        insertLocal(local5);

        Local local6 = new Local(setorLocal3, "Sala 2");
        insertLocal(local6);


    }

}
