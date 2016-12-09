package arekusanda.lyrical.aplicaciodadb;

/**
 * Created by ALEJANDRO on 06/12/2016.
 */
public class Constantes {
    private static final String IP = "http://ahto.epsevg.upc.edu";
    private static final String PUERTO_HOST = "80";
    private static final String URL = IP + ":" + PUERTO_HOST + "/~e7639176/php_dadb/";

    public static final String GET_ALL_COLONIAS = URL + "obtener_colonias.php";
    public static final String GET_COLONIA_ID = URL + "obtener_colonia_id.php";
    public static final String UPDATE_COLONIA = URL + "actualizar_colonia.php";
    public static final String DELETE_COLONIA = URL + "eliminar_colonia.php";
    public static final String INSERT_COLONIA = URL + "insertar_colonia.php";

}
