package edu.fjnu.Servlet.getEchart;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SendUserTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(SendUserTypeServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String userID = (String) request.getSession().getAttribute("userid");
        StudentDAO stu = new StudentDAOImpl();
        Student user = new Student();
        try {
            user = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        List<Student> tempList = new ArrayList<Student>();
        tempList.add(user);
        String jsonData = JSONArray.fromObject(tempList).toString();
        out.write(jsonData);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
