package arekusanda.lyrical.aplicaciodadb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListColoniesActivity extends AppCompatActivity {
    private ColoniaAdapter mColoniasAdapter;
    private ListView mColoniasList;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_colonies);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mColoniasList = (ListView) findViewById(R.id.llista_colonies);
        cargarAdaptador();




        //Todo: listeners items click and longclick
        mColoniasList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                eliminarItemLlista(i);
                return true;
            }
        });
    }

    private void eliminarItemLlista(int possicio) {
        //TODO: Revisar si és correcte això
        ColoniesRepository.getInstance().removeColonia((int) mColoniasAdapter.getItemId(possicio));
        mColoniasAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    private void cargarAdaptador() {
        VolleySingleton.getInstance(this).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.GET,
                        Constantes.GET_ALL_COLONIAS,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarRespuestaJSON(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("ListGatsActivity", "Error Volley: " + error.getMessage());
                            }
                        }
                )
        );
    }

    private void procesarRespuestaJSON(JSONObject response) {
        try {
            // Obtener atributo "estado"
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // EXITO
                    // Obtener array "metas" Json
                    JSONArray mensaje = response.getJSONArray("colonias");
                    // Parsear con Gson
                    Colonia[] colonias = gson.fromJson(mensaje.toString(), Colonia[].class);
                    // Inicializar adaptador
                    for (Colonia colonia:colonias) {
                        ColoniesRepository.getInstance().saveColonia(colonia);
                        Log.d("ALEJANDRO","Colonia recivida: "+colonia.toString());
                    }
                    mColoniasAdapter = new ColoniaAdapter(this, ColoniesRepository.getInstance().getColonies());
                    mColoniasList.setAdapter(mColoniasAdapter);
                    break;
                case "2": // FALLIDO
                    String mensaje2 = response.getString("mensaje");
                    Toast.makeText(
                            this,
                            mensaje2,
                            Toast.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
