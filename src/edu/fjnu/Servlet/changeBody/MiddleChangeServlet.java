package edu.fjnu.Servlet.changeBody;

import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.Infos.Middleinfo;
import edu.fjnu.Entity.UsersInformation.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class MiddleChangeServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MiddleChangeServlet.class);

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String benchTest = request.getParameter("benchTest");
        String age = request.getParameter("age");
        String pullUp = request.getParameter("pullUp");
        String skipRope = request.getParameter("skipRope");
        String sitAndReach = request.getParameter("sitAndReach");
        String userID = (String) request.getSession().getAttribute("userid");

        StudentDAO stu = new StudentDAOImpl();
        Student student = new Student();
        try {
            student = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        int sex = 0;
        if (student.getStu_Sex().equals("M")) {    //男生在公式中sex为1
            sex = 1;
        } else {
            sex = 0;
        }
        //智能避错机制
        if (Double.parseDouble(height) > 100) {
            //身高智能避免错误
            double temp = Double.parseDouble(height) / 100;
            height = Double.toString(temp);
        }

        //因为前端不能让用户输入自己的体脂率，所以在这里要进行一个运算，把前端传回并转换的String转化为Double类型再进行运算
        double BMI = Double.parseDouble(weight) / Double.parseDouble(height) / Double.parseDouble(height);
        double BFR = (1.2 * BMI) + (0.23 * Integer.parseInt(age)) - (10.8 * sex) - 5.4;
        DecimalFormat df = new DecimalFormat("#.00");
        String bfr = df.format(BFR);    //这里只保留两位小数
        String bmi = df.format(BMI);

        MiddleInfoDAO middle = new MiddleInfoDAOImpl();
        Middleinfo info = new Middleinfo(userID, student.getStu_Sex(), age, height, weight, bmi, bfr, pullUp, skipRope, benchTest, sitAndReach);

        try {
            Middleinfo user = middle.queryById(userID);
            if (user == null) {
                middle.add(info);
                stu.setType(userID, "Middle");
            } else {
                middle.set(info);
                stu.setType(userID, "Middle");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
