package com.patob.loginConArchivos.ui.registro;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.patob.loginConArchivos.Modelo.Usuario;
import com.patob.loginConArchivos.Request.ApiClient;
import com.patob.loginConArchivos.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> mUsuario;


    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Usuario> getmUsuario() {
        if(mUsuario==null){
            mUsuario=new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void cargarDatos(Intent intent){
        ApiClient api = new ApiClient();
        int existe = intent.getFlags();
        Usuario usuario = new Usuario();
        if(existe != -1){
            usuario = api.leer(getApplication());
        }
        mUsuario.setValue(usuario);
    }

    public void guardar(String dni, String nombre, String apellido, String email, String password) {
        if(!dni.equals("") && !nombre.equals("") && !apellido.equals("") && !email.equals("") && !password.equals("")){
            Usuario usuario = new Usuario(dni, nombre, apellido, email, password);
            ApiClient api = new ApiClient();
            api.guardar(getApplication(), usuario);
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        } else {
            Toast.makeText(getApplication(), "Debe ingresar datos en todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}
