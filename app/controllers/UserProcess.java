package controllers;

import play.data.validation.Constraints;

public class UserProcess {
    @Constraints.Required protected String rut;
    protected String password;

    public UserProcess(){

    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}