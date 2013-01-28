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

	public static Result index() {
		return ok(main.render("index", null));

	}

	public static Result login() {
		return TODO;
	}

	public static Result newUser() {
		return TODO;
	}
	//Saknas: Autentisera formulär, redirekta till rätt sida, alla routes

}
