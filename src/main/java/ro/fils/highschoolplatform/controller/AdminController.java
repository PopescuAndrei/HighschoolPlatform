/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/loginAdmin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Boolean loginUser(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        return mail.equals("admin") && password.equals("admin");
    }
}
