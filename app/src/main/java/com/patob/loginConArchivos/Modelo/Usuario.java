package com.patob.loginConArchivos.Modelo;


import java.io.Serializable;

public class Usuario implements Serializable {
    private String dni;
    private String apellido;
    private String nombre;
    private String mail;
    private  String password;

    public Usuario(String dni, String apellido, String nombre, String mail, String password) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
    }

    public Usuario() {
    }

    public String getDni() {

        return dni;
    }

    public void setDni(String dni) {

        this.dni = dni;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getMail() {

        return mail;
    }

    public void setMail(String mail) {

        this.mail = mail;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
