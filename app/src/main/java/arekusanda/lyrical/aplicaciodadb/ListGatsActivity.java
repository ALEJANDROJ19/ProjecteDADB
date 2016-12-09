package arekusanda.lyrical.aplicaciodadb;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class ListGatsActivity extends AppCompatActivity {
    private BaseAdapter mGatsAdapter;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView mGatsList = (ListView) findViewById(R.id.llista_gats);
        //cargarAdaptador();
        mGatsAdapter = new GatsAdapter(this,GatsRepository.getInstance().getGats());
        mGatsList.setAdapter(mGatsAdapter);

        mGatsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int possicio, long id) {
                Intent intent = new Intent(ListGatsActivity.this, GatActivity.class);
                intent.putExtra("gat",(Gat) mGatsAdapter.getItem(possicio));
                startActivity(intent);
            }
        });

        mGatsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                eliminarItemLlista(i);
                return true;
            }
        });
    }


    //TODO: Alejandro, aprende a hacer bien el trabajo. Gatos! no Colonias!
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
//        try {
//            // Obtener atributo "estado"
//            String estado = response.getString("estado");
//
//            switch (estado) {
//                case "1": // EXITO
//                    // Obtener array "metas" Json
//                    JSONArray mensaje = response.getJSONArray("colonias");
//                    // Parsear con Gson
//                    Colonia[] colonias = gson.fromJson(mensaje.toString(), Colonia[].class);
//                    // Inicializar adaptador
//                    //mGatsAdapter = new GatsAdapter(this,GatsRepository.getInstance().getGats());
//
//                    mGatsAdapter = new GatsAdapter(this, Arrays.asList(colonias));
//                    // Setear adaptador a la lista
//                    lista.setAdapter(adapter);
//                    break;
//                case "2": // FALLIDO
//                    String mensaje2 = response.getString("mensaje");
//                    Toast.makeText(
//                            this,
//                            mensaje2,
//                            Toast.LENGTH_LONG).show();
//                    break;
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }


    @Override
    protected void onResume() {
        //TODO: No funca
        super.onResume();
        mGatsAdapter.notifyDataSetChanged();
    }

    private void eliminarItemLlista(int possicio) {
        //TODO: Revisar si és correcte això
        GatsRepository.getInstance().removeGat((int) mGatsAdapter.getItemId(possicio));
        mGatsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
