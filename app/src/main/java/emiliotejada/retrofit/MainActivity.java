package emiliotejada.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import java.util.List;

import emiliotejada.retrofit.modelos.Cliente;
import emiliotejada.retrofit.rest.ApiClient;
import emiliotejada.retrofit.rest.cliente.ClienteInterface;
import emiliotejada.retrofit.rest.cliente.ClienteRest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
public class MainActivity extends AppCompatActivity {
    TableLayout layout;
    Context contexto;
    static List<Cliente> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto=this;
        layout=(TableLayout)findViewById(R.id.layout);

        ClienteRest clienteControlador = new ClienteRest();

        clienteControlador.getClientes(contexto,layout);


    }

    public void crearCliente(View v){
        Intent in=new Intent(this,formularioAlumno.class);
        startActivity(in);
    }
}
