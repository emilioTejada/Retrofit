package emiliotejada.retrofit.modelos;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emilio on 16/02/17.
 */

public class Cliente {

    @SerializedName("dni")
    private String dni;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellidos")
    private String apellidos;
    @SerializedName("telefono")
    private Integer   telefono;



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Cliente(String dni, String nombre, String apellidos, int telefono) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
