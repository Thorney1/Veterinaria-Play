package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class LoginController extends Controller {
    private final FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public LoginController(FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }
    public Result listForm(Http.Request request){
        Form<UserProcess> form = formFactory.form(UserProcess.class);
        return ok(views.html.form.render(form, request, messagesApi.preferred(request)));
    }
    public Result processLogin(Http.Request request) {
        Form<UserProcess> form = formFactory.form(UserProcess.class).bindFromRequest(request);
        if (form.hasErrors()) {
            return redirect(routes.LoginController.listForm());
        }

        UserProcess user = form.get();

        boolean verify = verify(user.getRut(), user.getPass());
        System.out.println(verify);

        if (verify) {
            int tipoUsuario = getTipoUsuario(user.getRut());
            System.out.println(tipoUsuario);
            if (tipoUsuario == 1) {
                // Redirigir a una página específica para tipo_usuario 1
                return redirect(routes.HomeController.homeVeterinario()).addingToSession(request, "connected", user.getRut());
            } else if (tipoUsuario == 0) {
                // Redirigir a una página específica para tipo_usuario 0
                return redirect(routes.HomeController.home()).addingToSession(request, "connected", user.getRut());
            } else {
                // Redirigir a una página de error en caso de valor de tipo_usuario inválido
                return redirect(routes.HomeController.error());
            }
        } else {
            // Usuario inválido, redirigir al formulario de inicio de sesión
            return redirect(routes.LoginController.listForm());
        }
    }

    public Result cerrarsesion(Http.Request request){
        return redirect(routes.LoginController.listForm()).removingFromSession(request, "connected");

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
