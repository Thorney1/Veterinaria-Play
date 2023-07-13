package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class TipoAnimal extends Model{
    @Id
    public int id;

    public String tipo;


    public static final Finder<Long, TipoAnimal> find = new Finder<>(TipoAnimal.class);


}
