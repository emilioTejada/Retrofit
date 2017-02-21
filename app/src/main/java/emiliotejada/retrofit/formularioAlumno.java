package emiliotejada.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import emiliotejada.retrofit.modelos.Cliente;


public class formularioAlumno extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_formulario_alumno);
        }

        public void enviarFormulario(View v){

            EditText aux=(EditText) findViewById(R.id.idCliente);
            String id=aux.getText().toString();
            aux=(EditText) findViewById(R.id.nombre);
            String nombre=aux.getText().toString();
            aux=(EditText) findViewById(R.id.apellidos);
            String apellidos=aux.getText().toString();
            aux=(EditText) findViewById(R.id.telefono);
            String telefono=aux.getText().toString();
            MainActivity.lista.add(new Cliente(id,nombre,apellidos,Integer.parseInt(telefono)));
            Intent in=new Intent(this,MainActivity.class);
            startActivity(in);
            //En este metodo deberiamos enviar los datos al servidor

        }
    }