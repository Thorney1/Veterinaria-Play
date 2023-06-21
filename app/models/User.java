package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class User extends Model{

    @Id
    public int id;
    public String rut;
    public String pass;

    public int tipo_usuario;
    public static final Finder<Long, User> find = new Finder<>(User.class);
}