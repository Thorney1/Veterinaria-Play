package controllers;

import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


    public Result login() {
        return ok(views.html.login.render());
    }

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
