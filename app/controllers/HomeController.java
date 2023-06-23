package controllers;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;
import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {



    public Result home() {

        return ok(views.html.home.render());
    }

    public Result homeVeterinario() {
        return ok(views.html.homeVeterinario.render());
    }

    public Result error() {
        return ok(views.html.error.render());
    }

    public Result mascotas() {
        return ok(views.html.mascotas.render());
    }

    public Result atenciones() {
        return ok(views.html.atenciones.render());
    }

    public Result atencionesAtender() {
        return ok(views.html.atencionesAtender.render());
    }

    public Result mascotasCrear() {
        return ok(views.html.mascotasCrear.render());
    }

    public Result register() {
        return ok(views.html.register.render());
    }




}

