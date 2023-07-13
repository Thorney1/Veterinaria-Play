package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;

@Entity
public class Diagnostico extends Model{
    @Id
    public int id;

    public int animal_id;

    public int veterinaria_id;

    public String descripcion;

    public String medicamento;


    public String uuid;





}
