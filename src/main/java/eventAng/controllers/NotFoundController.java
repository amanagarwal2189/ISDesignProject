package eventAng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NotFoundController {

	@RequestMapping(value = "/notFoundPage", method = RequestMethod.GET)
    public String directToLogin() {
        return "404";
    }
}