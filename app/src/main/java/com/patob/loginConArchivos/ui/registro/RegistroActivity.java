package com.patob.loginConArchivos.ui.registro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.patob.loginConArchivos.Modelo.Usuario;
import com.patob.loginConArchivos.R;
import com.patob.loginConArchivos.databinding.ActivityMainBinding;
import com.patob.loginConArchivos.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {
    private RegistroActivityViewModel vm;
    private ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = binding.etDni.getText().toString();
                String nombre = binding.etNombre.getText().toString();
                String apellido = binding.etApellido.getText().toString();
                String email = binding.etEmail.getText().toString();
                String password = binding.etPass.getText().toString();

                vm.guardar(dni, nombre, apellido, email, password);
            }
        });

        vm.getmUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etDni.setText(usuario.getDni());
                binding.etNombre.setText(usuario.getNombre());
                binding.etApellido.setText(usuario.getApellido());
                binding.etEmail.setText(usuario.getMail());
                binding.etPass.setText(usuario.getPassword());
            }
        });
        Intent intent = getIntent();
        vm.cargarDatos(intent);
    }
}