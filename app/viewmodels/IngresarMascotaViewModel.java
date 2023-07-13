package viewmodels;

import models.TipoAnimal;

import java.util.Set;

public class IngresarMascotaViewModel {
    //Datos cliente
    public String rutCliente;
    public String nombreCliente;
    public String apellidoCliente;
    public String email;
    public String direccion;
    public int telefono;

    //Datos mascota
    public String nombreMascota;
    public int tipoMascota;
    public String raza;
    public String edad;
    public String chip;
    public String descripcion;


    public Set<TipoAnimal> getTipoAnimal(){
        return TipoAnimal.find.query().findSet();
    }

}
