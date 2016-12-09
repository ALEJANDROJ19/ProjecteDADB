package arekusanda.lyrical.aplicaciodadb;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;


public class GatActivity extends AppCompatActivity {
    EditText nom, any_naixement, genere, raça, num_chip, data_def, causa_def, caracter, descripcio;
    ToggleButton edit;
    Button save;
    Boolean editable = true;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    HashMap<String, EditText> list_editables;
    Gat gat;
    private static String myFormat = "dd/MM/yyyy"; //In which you need put here

    private static final String sql_column_nom = "nombre";
    private static final String sql_column_any_naixement = "año_nacimiento";
    private static final String sql_column_genere = "genero";
    private static final String sql_column_raça = "raza";
    private static final String sql_column_num_chip = "num_chip";
    private static final String sql_column_data_def = "fecha_defunción";
    private static final String sql_column_causa_def = "causa_defunción";
    private static final String sql_column_caracter = "caracter";
    private static final String sql_column_descripcio = "descripción";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gat);
        init();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void init() {
        list_editables = new HashMap<>();
        nom = (EditText) findViewById(R.id.editText_nomGat); list_editables.put(sql_column_nom,nom);
        any_naixement = (EditText) findViewById(R.id.editText_anyGat); list_editables.put(sql_column_any_naixement,any_naixement);
        genere = (EditText) findViewById(R.id.editText_genere); list_editables.put(sql_column_genere,genere);
        raça = (EditText) findViewById(R.id.editText_raca); list_editables.put(sql_column_raça,raça);
        num_chip = (EditText) findViewById(R.id.editText_numchip); list_editables.put(sql_column_num_chip,num_chip);
        data_def = (EditText) findViewById(R.id.editText_datadefGat); list_editables.put(sql_column_data_def,data_def);
        causa_def = (EditText) findViewById(R.id.editText_causadef); list_editables.put(sql_column_causa_def,causa_def);
        caracter = (EditText) findViewById(R.id.editText_caracter); list_editables.put(sql_column_caracter,caracter);
        descripcio = (EditText) findViewById(R.id.editText_descripcioGat); list_editables.put(sql_column_descripcio,descripcio);
        edit = (ToggleButton) findViewById(R.id.editar_gat);
        save = (Button) findViewById(R.id.buton_guardar);

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

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        data_def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        GatActivity.this,
                        date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        try {
             gat = (Gat)getIntent().getSerializableExtra("gat");
        } catch (Exception e){
            Log.e("LOG", e.getMessage());
        }

        if (gat != null) {
            nom.setText(gat.getNombre());
            any_naixement.setText(String.valueOf(gat.getAnyo_nacimiento()));
            raça.setText(gat.getRaza());
            genere.setText(gat.getGenero());
            num_chip.setText(String.valueOf(gat.getNum_chip()));
            if(gat.getFecha_def() != null) data_def.setText(gat.getFecha_def().toString());
            causa_def.setText(gat.getCausa_def());
            caracter.setText(gat.getCaracter());
        }
    }

    private void updateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        data_def.setText(sdf.format(myCalendar.getTime()));
    }


    private void save_state() {
        if (editable) changeEditAvariable();
        //TODO: Notify changes
        if (gat != null) {
            gat.setNombre(nom.getText().toString());
            gat.setAnyo_nacimiento(Integer.valueOf(any_naixement.getText().toString()));
            gat.setRaza(raça.getText().toString());
            gat.setGenero(genere.getText().toString());
            gat.setNum_chip(Integer.valueOf(num_chip.getText().toString()));
            if (gat.getFecha_def() != null) gat.setFecha_def(myCalendar.getTime());
            gat.setCausa_def(causa_def.getText().toString());
            gat.setCaracter(caracter.getText().toString());
            Log.d("DEB", gat.toString());
        }
    }

    private void changeEditAvariable() {
        editable = !editable;
        for (EditText e : list_editables.values()) {
            e.setEnabled(editable);
        }
        edit.setChecked(editable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //TODO: save the modifications!
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
