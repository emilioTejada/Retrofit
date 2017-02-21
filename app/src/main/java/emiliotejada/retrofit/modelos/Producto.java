package emiliotejada.retrofit.modelos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Emilio on 21/02/17.
 */

public class Producto {

    @SerializedName("ref")
    private String ref;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("precio")
    private float precio;


}
