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

    private final FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
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




    public Result listForm(Http.Request request){
        Form<UserProcess> form = formFactory.form(UserProcess.class);
        return ok(views.html.form.render(form, request, messagesApi.preferred(request)));
    }
    public Result processLogin(Http.Request request) {
        Form<UserProcess> form = formFactory.form(UserProcess.class).bindFromRequest(request);
        UserProcess user = form.get();

        boolean verify = verify(user.getRut(), user.getPass());
        System.out.println(verify);

        if (verify) {
            int tipoUsuario = getTipoUsuario(user.getRut());
            System.out.println(tipoUsuario);
            if (tipoUsuario == 1) {
                // Redirigir a una página específica para tipo_usuario 1
                return redirect(routes.HomeController.homeVeterinario());
            } else if (tipoUsuario == 0) {
                // Redirigir a una página específica para tipo_usuario 0
                return redirect(routes.HomeController.home());
            } else {
                // Redirigir a una página de error en caso de valor de tipo_usuario inválido
                return redirect(routes.HomeController.error());
            }
        } else {
            // Usuario inválido, redirigir al formulario de inicio de sesión
            return redirect(routes.HomeController.listForm());
        }
    }

    private boolean verify(String rut, String pass) {
        User user = User.find.query().where()
                .eq("rut", rut)
                .eq("pass", pass)
                .findOne();

        return user != null;
    }

    private int getTipoUsuario(String rut) {
        User user = User.find.query().where()
                .eq("rut", rut)
                .findOne();

        return (user != null) ? user.tipo_usuario : -1;
    }


}

