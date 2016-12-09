package arekusanda.lyrical.aplicaciodadb;

/**
 * Created by ALEJANDRO on 27/11/2016.
 */
public class Colonia {
    private int id;
    private String nombre, dirección, asociación, administrador;

    public Colonia(int id, String nombre, String dirección, String asociación, String administrador) {
        this.id = id;
        this.nombre = nombre;
        this.dirección = dirección;
        this.asociación = asociación;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getAsociación() {
        return asociación;
    }

    public void setAsociación(String asociación) {
        this.asociación = asociación;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dirección='" + dirección + '\'' +
                ", asociación='" + asociación + '\'' +
                ", administrador='" + administrador + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass())
            return isEqual((Colonia) obj);
        return super.equals(obj);
    }

    public boolean isEqual(Colonia colonia) {
        return this.id == colonia.getId() &&
                this.nombre.compareTo(colonia.getNombre()) == 0 &&
                this.dirección.compareTo(colonia.getDirección()) == 0 &&
                this.asociación.compareTo(colonia.getAsociación()) == 0 &&
                this.administrador.compareTo(colonia.getAdministrador()) == 0;
    }
}
