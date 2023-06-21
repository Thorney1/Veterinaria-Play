package controllers;

import play.data.validation.Constraints;

public class UserProcess {
    @Constraints.Required protected String rut;
    protected String pass;
    protected int tipo_usuario;

    public UserProcess(){

    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getRut() {
        return rut;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getPass() {
        return pass;
    }



    public void setTipoUsuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getTipoUsuario() {
        return tipo_usuario;
    }



}