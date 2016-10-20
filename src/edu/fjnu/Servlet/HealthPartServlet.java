package edu.fjnu.Servlet;

import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Service.HealthPartService;
import edu.fjnu.Service.StudentService;
import edu.fjnu.exception.ApplicationException;
import edu.fjnu.exception.HealthEatException;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/HealthPartServlet")
public class HealthPartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(HealthPartServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        try {
            String stuID = (String) request.getSession().getAttribute("userid");
            StudentService studentService = new StudentService();
            Student student = studentService.getStudentByID(stuID);
            HealthPartService healthPartService = new HealthPartService();
            Map<String, String> healthPartMap = healthPartService.getHealthEatInfoByStu(student);
            out.write(JSONArray.fromObject(healthPartMap).toString());
        } catch (HealthEatException e) {
            logger.error(e.getMessage());
        } catch (ApplicationException e) {
            logger.error(e.getMessage());
        } finally {
            out.close();
        }
    }

}
