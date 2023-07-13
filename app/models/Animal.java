package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;

import java.util.Date;

@Entity
public class Animal extends Model{
    @Id

    public int id;
    public String animalNombre;
    public int tipo_animal_id;
    public String raza;
    public String edad;
    public String chip;
    public String descripcion;
    public Date ingreso;
    public int cliente_id;

    public int estado_animal_id;
}
