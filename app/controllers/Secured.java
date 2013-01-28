package controllers;

import play.*;
import play.mvc.*;
import play.mvc.http.*;

import models.*;

public class Secured extends Security.Authenticator {

	@Override
	public String getUsername(Context ctx) {
		return ctx.session().get("username");	
	}

	@Override
	public Result onUnathorized(Context ctx) {
		return redirect(routes.Application.login());
	}
}

