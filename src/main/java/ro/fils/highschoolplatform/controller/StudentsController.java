/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import com.itextpdf.text.BadElementException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.repository.StudentDAO;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;
<<<<<<< HEAD
import ro.fils.highschoolplatform.util.Encryption;
=======
import ro.fils.highschoolplatform.util.PDFCreator;
>>>>>>> ca8b597584122c939c044b380122e55da72ace5a

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/students")
public class StudentsController {
    private static final int BUFFER_SIZE = 4096;
    
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Student> getAllStudents() {
        studentService = new StudentServiceImpl();
        return (ArrayList) studentService.findAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public @ResponseBody
    Student getOneProject(@PathVariable("studentId") int studentId) {
        studentService = new StudentServiceImpl();
        return studentService.getStudent(studentId);
    }
    
<<<<<<< HEAD
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    void insertStudent(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "clazz", required = false) String clazz
            , @RequestParam(value = "password", required = false) String pass)
    {
        StudentDAO sDao = new StudentDAO();
        Student s = new Student();
        String split[] = name.split(" ");
        s.setFirstName(split[0]);
        s.setEmail(email);
        s.setClassId(Integer.parseInt(clazz));
        s.setPassword(Encryption.getHash(pass));
       
        if(split.length > 1)
            s.setLastName(name.split(" ")[1]);
        sDao.insertStudent(s);
=======
    @RequestMapping(method = RequestMethod.GET, value = "/downloadPDF/{studentId}")
    public void downloadPDF(HttpServletRequest request,
            HttpServletResponse response, @PathVariable("studentId") int studentId) throws FileNotFoundException, IOException, BadElementException {
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        String fullPath = appPath + "Projects.pdf";
        PDFCreator creator = new PDFCreator();
        creator.saveAsPDF(studentId, fullPath);
        System.out.println("appPath = " + appPath);

        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

>>>>>>> ca8b597584122c939c044b380122e55da72ace5a
    }
}
