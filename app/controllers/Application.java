package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {
	
	public static class Login {
		public String username;
		public String password;

		public String validate() {
			if(User.authenticate(username, password) == null) {
				return "Fel lösenord eller användarnamn!";
			}
			return null;
		}
	}
	
	static Form<User> userForm = form(User.class);

	public static Result login() {
		return ok(
				login.render(form(Login.class))
				);
	}

	public static Result newUser() {
		Form<Task> filledForm = userForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(Task.all(), filledForm)
					);
		} else {
			Task.create(filledForm.get());
			return redirect(routes.Application.users());  
		}
	}
	//Saknas: Autentisera formulär, redirekta till rätt sida, alla routes

}
