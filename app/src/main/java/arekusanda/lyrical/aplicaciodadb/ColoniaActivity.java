package arekusanda.lyrical.aplicaciodadb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.util.HashMap;

public class ColoniaActivity extends AppCompatActivity {
    private EditText nom, direccio, associacio, responsable;
    private ToggleButton edit;
    private Button save;
    private Boolean editable = true;
    private HashMap<String,EditText> list_editables;

    private static final String sql_column_nom = "nom";
    private static final String sql_column_direccio = "dirección";
    private static final String sql_column_associacio = "asociación";
    private static final String sql_column_responsable = "administrador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colonia);
        init();
    }

    private void init() {
        list_editables = new HashMap<>();
        nom = (EditText) findViewById(R.id.nomColonia); list_editables.put(sql_column_nom,nom);
        direccio = (EditText) findViewById(R.id.direccioColonia); list_editables.put(sql_column_direccio,direccio);
        associacio = (EditText) findViewById(R.id.associacio); list_editables.put(sql_column_associacio,associacio);
        responsable = (EditText) findViewById(R.id.responsable); list_editables.put(sql_column_responsable,responsable);
        edit = (ToggleButton) findViewById(R.id.editar_colonia);
        save = (Button) findViewById(R.id.save_colonia);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeEditAvariable();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_state();
            }
        });

        changeEditAvariable();
    }

    private void changeEditAvariable() {
        editable = !editable;
        for (EditText e : list_editables.values()) {
            e.setEnabled(editable);
        }
        edit.setChecked(editable);
    }

    private void save_state() {
        if (editable) changeEditAvariable();
        //SQL Query;
    }
}
