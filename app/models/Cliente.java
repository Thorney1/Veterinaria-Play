package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class Cliente extends Model{
    @Id
    public int id;

    public String name;

    public String apellido;

    public String cli_rut;

    public int telefono;


    public String direccion;

    public String email;

    public static final Finder<Long, Cliente> find = new Finder<>(Cliente.class);




}
