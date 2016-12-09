package arekusanda.lyrical.aplicaciodadb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ALEJANDRO on 06/12/2016.
 */
public class ColoniaAdapter extends ArrayAdapter<Colonia> {
    public ColoniaAdapter(Context context, List<Colonia> colonias) {
        super(context, 0, colonias);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtener el inflador
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Existeix view actual?
        if (convertView == null) {
            //Inflar el item de la llista
            convertView = inflater.inflate(R.layout.list_item_colonia, parent, false);
        }

        //Referencies IG (UI)
        TextView nom = (TextView) convertView.findViewById(R.id.tv_nomColonia);
        TextView direccio = (TextView) convertView.findViewById(R.id.tv_direccio);
        TextView responsable = (TextView) convertView.findViewById(R.id.tv_responsable);


        //Item actual
        Colonia colonia = getItem(position);

        //Setup
        nom.setText(colonia.getNombre());
        direccio.setText(colonia.getDirección());
        responsable.setText(colonia.getAdministrador());

        Log.d("ALEJANDRO", "Eoooo");

        return convertView;
    }
}
