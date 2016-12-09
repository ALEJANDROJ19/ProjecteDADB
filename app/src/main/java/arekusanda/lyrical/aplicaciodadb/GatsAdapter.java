package arekusanda.lyrical.aplicaciodadb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ALEJANDRO on 03/12/2016.
 */
public class GatsAdapter extends ArrayAdapter<Gat> {
    public GatsAdapter(Context context, List<Gat> gats) {
        super(context, 0, gats);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtener el inflador
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Existeix view actual?
        if (convertView == null) {
            //Inflar el item de la llista
            convertView = inflater.inflate(R.layout.list_item_gat, parent, false);
        }

        //Referencies IG (UI)
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView nom = (TextView) convertView.findViewById(R.id.tv_nom);
        TextView genere = (TextView) convertView.findViewById(R.id.tv_genere);

        //Item actual
        Gat gat = getItem(position);

        //Setup
        Glide.with(getContext()).load(gat.getAvatar()).into(avatar);
        nom.setText(gat.getNombre());
        genere.setText(gat.getGenero());

        return convertView;

    }
}
