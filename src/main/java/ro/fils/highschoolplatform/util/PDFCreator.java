/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import ro.fils.highschoolplatform.domain.Absence;
import ro.fils.highschoolplatform.domain.Grade;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.dto.AbsenceDTO;
import ro.fils.highschoolplatform.dto.GradeDTO;
import ro.fils.highschoolplatform.service.impl.AbsenceServiceImpl;
import ro.fils.highschoolplatform.service.impl.ClazzServiceImpl;
import ro.fils.highschoolplatform.service.impl.GradeServiceImpl;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;

/**
 *
 * @author andre
 */
public class PDFCreator {

    public void saveAsPDF(int studentId, String path) throws BadElementException, IOException {
        Student std = new StudentServiceImpl().getStudent(studentId);
        ArrayList<GradeDTO> grades = new GradeServiceImpl().getAllGradesForStudent(studentId);
        ArrayList<AbsenceDTO> absences = new AbsenceServiceImpl().getAllAbsencesForStudent(studentId);
        String className = new ClazzServiceImpl().getStudentClazz(studentId).getName();
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            document.add(new Paragraph("First name:" + std.getFirstName() + "\nLast name: " + std.getLastName() + "\nEmail: " + std.getEmail() + "\nClass: " + className));
            document.add(new Paragraph("\nGRADES: "));
            PdfPTable table = new PdfPTable(3);

            table.addCell("Date");
            table.addCell("Value");
            table.addCell("Course name");
            for (GradeDTO gp : grades) {
                table.addCell(String.valueOf(gp.getDate()));
                table.addCell(String.valueOf(gp.getValue()));
                table.addCell(gp.getCourseName());
            }
            document.add(table);

            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\nAbsences"));
            PdfPTable table2 = new PdfPTable(2);

            table2.addCell("Date");
            table2.addCell("Course name");
            for (AbsenceDTO gp : absences) {
                table2.addCell(String.valueOf(gp.getDate()));
                table2.addCell(gp.getCourseName());
            }
            document.add(table2);

            document.close();
            writer.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error in creating pdf");
        }
    }
}
