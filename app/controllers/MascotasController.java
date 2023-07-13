package controllers;

import io.ebean.DB;
import io.ebean.Ebean;
import io.ebean.SqlRow;
import models.Animal;
import models.Cliente;
import models.MascotasView_Result;
import models.User;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;
import viewmodels.IngresarMascotaViewModel;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

import static play.mvc.Results.ok;

public class MascotasController {

    private final FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public MascotasController(FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result index(){
        var mascotas = getMascotas();
        return ok(views.html.mascotas.render(mascotas));
    }

    public Result create(Http.Request request) {
        Form<IngresarMascotaViewModel> form = formFactory.form(IngresarMascotaViewModel.class);
        return ok(views.html.mascotasCrear.render(form, request));
    }

    public Result store(Http.Request request){
        Form<IngresarMascotaViewModel> form = formFactory.form(IngresarMascotaViewModel.class).bindFromRequest(request);
        IngresarMascotaViewModel formObj = form.get();

        var existeCliente =     Cliente.find.query().where()
                .eq("cli_rut", formObj.rutCliente)
                .findOne();

        if(existeCliente == null){
            Cliente cliente = new Cliente();
            cliente.name = formObj.nombreCliente;
            cliente.cli_rut = formObj.rutCliente;
            cliente.apellido = formObj.apellidoCliente;
            cliente.email = formObj.email;
            cliente.telefono = formObj.telefono;
            cliente.direccion = formObj.direccion;
            Ebean.save(cliente);

            existeCliente = Cliente.find.query().where()
                    .eq("cli_rut", formObj.rutCliente)
                    .findOne();
        }

        Animal animal = new Animal();
        animal.animalNombre = formObj.nombreMascota;
        animal.cliente_id = existeCliente.id;
        animal.chip = formObj.chip;
        animal.descripcion = formObj.descripcion;
        animal.edad = formObj.edad;
        animal.tipo_animal_id = formObj.tipoMascota;
        animal.ingreso =new Date();
        animal.raza = formObj.raza;
        Ebean.save(animal);

        System.out.println("Datos del cliente:");
        System.out.println("Rut: " + formObj.rutCliente);
        System.out.println("Nombre: " + formObj.nombreCliente);
        System.out.println("Apellido: " + formObj.apellidoCliente);
        System.out.println("Email: " + formObj.email);
        System.out.println("Dirección: " + formObj.direccion);
        System.out.println("Teléfono: " + formObj.telefono);

        System.out.println("\nDatos de la mascota:");
        System.out.println("Nombre: " + formObj.nombreMascota);
        System.out.println("Tipo de mascota: " + formObj.tipoMascota);
        System.out.println("Raza: " + formObj.raza);
        System.out.println("Edad: " + formObj.edad);
        System.out.println("Chip: " + formObj.chip);
        System.out.println("Descripción: " + formObj.descripcion);
        return ok(views.html.mascotasCrear.render(form, request));
    }



    private Set<MascotasView_Result> getMascotas(){
        List<SqlRow> rows = DB.sqlQuery("select * from get_mascotas_view").findList();
        Set<MascotasView_Result> mascotas = new HashSet<MascotasView_Result>();
        System.out.println("datos de mascota: " + rows.size());
for (SqlRow row : rows){
var objeto = new MascotasView_Result();
    objeto.id = row.getInteger("id");
    objeto.fechaIngreso = row.getString("fechaIngreso");
    objeto.estado = row.getString("estado");
    objeto.rutCliente = row.getString("cli_rut");
    objeto.tipoAnimal = row.getString("tipo");
    objeto.raza = row.getString("raza");
    objeto.nombreAnimal = row.getString("animal_nombre");
    objeto.edad = row.getString("edad");
    objeto.chip = row.getString("chip");
    objeto.descripcion = row.getString("descripcion");
    mascotas.add(objeto);
}
return mascotas;
    }

}
