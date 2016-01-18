/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Clazz;
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.domain.Pair;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.repository.ClazzDAO;
import ro.fils.highschoolplatform.repository.CoursesDAO;
import ro.fils.highschoolplatform.repository.MapClassCourseProfDAO;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.repository.StudentDAO;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/adminClazzController")
public class AdminClazzController {

    ProfessorDAO p = new ProfessorDAO();
 

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Professor> getOneProfessor(@RequestParam(value = "courseId", required = false) String courseId) {
        System.out.println("getOneProfessor"+courseId);
        return p.getProfessorByCourseId(Integer.parseInt(courseId));
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    void update(
            @RequestParam(value = "classId", required = false) String classId
            ,@RequestParam(value = "courseId", required = false) String courseId 
            ,@RequestParam(value = "profId", required = false) String profId ) 
    {
        MapClassCourseProfDAO d= new MapClassCourseProfDAO();
        d.update(Integer.parseInt(classId), Integer.parseInt(courseId), Integer.parseInt(profId));
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody
    List<Pair> findProfessors(
            @RequestParam(value = "classId", required = false) String classId) 
    {
        MapClassCourseProfDAO d= new MapClassCourseProfDAO();
        CoursesDAO cDao = new CoursesDAO();
        ProfessorDAO pDao = new ProfessorDAO();
        List<Course> courses = cDao.getAll();
        ClazzDAO clDao = new ClazzDAO();
        Clazz clazz = clDao.getClazz(Integer.parseInt(classId));
        List<Pair> pairs= new ArrayList<>();
       
        for(Course c:courses)
        {
            int pID = d.findProfessor(Integer.parseInt(classId), c.getId());
            Professor p = pDao.getProfessorById(pID);
            if(p!=null)
            {
                pairs.add(new Pair(c.getName(),p.getFirstName()+" "+p.getLastName()));
            }
            
        }
        return pairs;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Pair> findStudents(
            @RequestParam(value = "classId", required = false) String classId) 
    {
        StudentDAO sDao = new StudentDAO();
        List<Student> students = sDao.getAllStudentsInClass(Integer.parseInt(classId));
        ClazzDAO cDao = new ClazzDAO();
        Clazz clazz = cDao.getClazz(Integer.parseInt(classId));
        List<Pair> pairs= new ArrayList<>();
        for(Student s:students)
        {
            pairs.add(new Pair(s.getFirstName()+" "+s.getLastName(),clazz.getName()));
        }
        return pairs;
    }
}
