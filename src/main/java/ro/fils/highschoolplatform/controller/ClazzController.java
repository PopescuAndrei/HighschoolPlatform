/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

/**
 *
 * @author andre
 */
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Clazz;
import ro.fils.highschoolplatform.service.ClazzService;
import ro.fils.highschoolplatform.service.impl.ClazzServiceImpl;

@Controller
@RequestMapping("/clazzes")
public class ClazzController {

    ClazzService clazzService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{clazzId}")
    public @ResponseBody
    Clazz getStudentClazz(@PathVariable("clazzId") int clazzId) {
        System.out.println("claaaaaaaaaaaaaaaasaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + clazzId);
        clazzService = new ClazzServiceImpl();
        return clazzService.getClazz(clazzId);
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Clazz> getAllClazzes() {
        clazzService = new ClazzServiceImpl();
        return (ArrayList) clazzService.findAllClazzez();
    }
}
