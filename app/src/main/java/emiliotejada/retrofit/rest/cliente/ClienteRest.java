package emiliotejada.retrofit.rest.cliente;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import emiliotejada.retrofit.modelos.Cliente;
import emiliotejada.retrofit.rest.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Emilio on 21/02/17.
 */

public class ClienteRest {
    private static final ClienteInterface apiService = ApiClient.getClient().create(ClienteInterface.class);
    private List<Cliente> listado;

    public void ClienteRest(){
        this.listado= new ArrayList<Cliente>();
    }
    public void setListado(List<Cliente> listado){
        this.listado=listado;
    }
    public List<Cliente> getListado(){
        return listado;
    }
    /**
     * OBTENCIÓN DEL LISTADO DE CLIENTES
     */
    public void getClientes(final Context context, final TableLayout layout){
       Call <List< Cliente >> call = apiService.getClientes();
        call.enqueue(new Callback<List<Cliente>>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                listado = response.body();
                mostrarClientes(context,layout);
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Log.e("Cliente ERROR:", t.toString());
            }
        });
    }

    public Cliente getCliente(int dni){
        Cliente clien = null;

        Call<Cliente>callBorrar = apiService.borrarCliente(233331) ;
        callBorrar.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Log.d("Respuesta de borrado", response.body().toString());

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {

            }
        });


        return clien;
    }




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void mostrarClientes(Context context, TableLayout layout){
        for (Cliente cli : this.getListado()){
           // Log.d("Cliente", ""+l);
            TableRow fila=new TableRow(context);
            fila.addView(textViewFormateado(cli.getDni(),context,layout));
            fila.addView(textViewFormateado(cli.getNombre(),context, layout));
            fila.addView(textViewFormateado(cli.getApellidos(),context, layout));
            fila.addView(textViewFormateado(""+cli.getTelefono(),context, layout));

            layout.addView(fila);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public TextView textViewFormateado(String text, Context context, TableLayout layout){

        TextView elemento=new TextView(context);

        elemento.setWidth(layout.getWidth());
        elemento.setHeight(140);
        elemento.setText(text);
        elemento.setTextSize(25);
        elemento.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        return elemento;
    }
}
