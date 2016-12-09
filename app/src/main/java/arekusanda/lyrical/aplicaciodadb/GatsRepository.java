package arekusanda.lyrical.aplicaciodadb;

import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ALEJANDRO on 03/12/2016.
 */
public class GatsRepository {
    private static GatsRepository repository;
    private List<Gat> items = new ArrayList<>();

    //Patró Singleton
    public static GatsRepository getInstance() {
        if (repository == null){
            repository = new GatsRepository();
        }
        return repository;
    }

    private GatsRepository() {
        saveGat(new Gat("Gato1","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato2","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato3","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato4","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato5","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato6","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
        saveGat(new Gat("Gato7","Macho","Gato",1,"","Cariñoso",2004,R.drawable.logo,null));
    }

    private void saveGat(Gat gat) {
        items.add(gat);
    }

    public void removeGat(int possicio) {
        items.remove(possicio);
    }

    public List<Gat> getGats() {
        return items;
    }
}
