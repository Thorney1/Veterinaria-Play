package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class EstadoAnimal extends Model{
    @Id
    public int id;

    public String estado;
}
