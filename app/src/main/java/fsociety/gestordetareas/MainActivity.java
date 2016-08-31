package fsociety.gestordetareas;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText Nombre;
    EditText Email;
    Button Guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lo que hacemos aqui es instanciar los valores que estan en nulos apartir de la clase padre
        Nombre = (EditText) findViewById(R.id.txtNombre);
        final EditText EmailValidate= (EditText) findViewById(R.id.txtEmail);


        Guardar= (Button) findViewById(R.id.btnGuardar);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                String email= EmailValidate.getText().toString().trim();
                String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (nombre.isEmpty()) {
                String mensaje = "Favor Complete el campo Nombre";
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                return;
            }
            if (nombre.length()<=3) {
                String mensaje = "Nombre de Usuario demasiado Corto";
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                return;
            }
            if (email.matches(emailPattern)){
                String mensaje = "Hola " + nombre + " " + email ;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }else{
                String mensaje = "Email Invalido" ;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }


            }

        });
    }
}
