package sk.tuke.coronastatapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.coronastatapp.service.VaccinationContactService;

@Controller
//@Scope(WebApplicationContext.SCOPE_SESSION)
public class DbAdministrationController {

    @Autowired
    VaccinationContactService vaccinationContactService;


}
