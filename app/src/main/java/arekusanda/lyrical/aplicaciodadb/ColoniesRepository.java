package arekusanda.lyrical.aplicaciodadb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEJANDRO on 03/12/2016.
 */
public class ColoniesRepository {
    private static ColoniesRepository repository;
    private List<Colonia> items = new ArrayList<>();

    //Patró Singleton
    public static ColoniesRepository getInstance() {
        if (repository == null){
            repository = new ColoniesRepository();
        }
        return repository;
    }

    private ColoniesRepository() {
        saveColonia(new Colonia(1,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
        saveColonia(new Colonia(2,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
//        saveColonia(new Colonia(3,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
//        saveColonia(new Colonia(4,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
//        saveColonia(new Colonia(5,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
//        saveColonia(new Colonia(6,"Colonia1","c/asdfgh","asdfgh","asdfghj"));
    }

    public void saveColonia(Colonia colonia) {
        if (items.indexOf(colonia) == -1)
            items.add(colonia);
    }

    public void removeColonia(int possicio) {
        items.remove(possicio);
    }

    public List<Colonia> getColonies() {
        return items;
    }
}
