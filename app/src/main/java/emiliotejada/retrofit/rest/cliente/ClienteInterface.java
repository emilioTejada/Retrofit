package emiliotejada.retrofit.rest.cliente;

/**
 * Created by Emilio on 16/02/17.
 */
import java.util.List;

import emiliotejada.retrofit.modelos.Cliente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClienteInterface {
        @GET("cliente")
        Call<List<Cliente>> getClientes();

        @GET("cliente/{dni}")
        Call<Cliente> getCliente(@Path("dni") int dni);

        @POST("cliente")
        Call<Cliente> createCliente(@Body Cliente cliente);

        @PUT("cliente/{dni}")
        Call<Cliente> actualizarCliente(@Path("dni") int id, @Body Cliente cliente);

        @DELETE("cliente/{dni}")
        Call<Cliente> borrarCliente(@Path("dni") int id);
    }
