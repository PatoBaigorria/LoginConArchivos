package com.patob.loginConArchivos.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.patob.loginConArchivos.R;
import com.patob.loginConArchivos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding.etMail.requestFocus();

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = binding.etMail.getText().toString();
                String password = binding.etPassword.getText().toString();
                vm.acceso(mail, password);
                binding.etMail.setText("");
                binding.etPassword.setText("");
            }
        });

        binding.btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vm.registro();
            }
        });

    }
}