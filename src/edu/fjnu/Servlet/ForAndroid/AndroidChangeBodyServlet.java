package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.Infos.Highinfo;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Infos.Middleinfo;
import edu.fjnu.Entity.Infos.Primaryinfo;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.Student;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AndroidChangeBodyServlet extends HttpServlet {

    /**
     * 修改信息接口
     */
    private static final long serialVersionUID = 6016247779933283663L;

    private static Logger logger = LoggerFactory.getLogger(AndroidChangeBodyServlet.class);

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
        this.doPost(request, response);
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
        String userID = request.getParameter("userID");
        String type = request.getParameter("type");//用户类型（年龄层）
        StudentDAO student = new StudentDAOImpl();
        Student user = new Student();
        try {
            user = student.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (type.equals("Primary")) {
            //小学生
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String shortRun = request.getParameter("shortRun");
            String age = request.getParameter("age");
            String FVC = request.getParameter("FVC");
            String skipRope = request.getParameter("skipRope");
            String sitAndReach = request.getParameter("sitAndReach");

            int sex = 0;
            if (user.getStu_Sex().equals("M")) {    //男生在公式中sex为1
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

            PrimaryInfoDAO primary = new PrimaryInfoDAOImpl();
            Primaryinfo info = new Primaryinfo(userID, user.getStu_Sex(), age, height, weight, bmi, bfr, FVC, shortRun, skipRope, sitAndReach);

            try {
                Primaryinfo temp = primary.queryById(userID);
                if (temp == null) {
                    primary.add(info);
                    student.setType(userID, "Primary");
                } else {
                    primary.set(info);
                    student.setType(userID, "Primary");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (type.equals("Middle")) {
            //初中生
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String benchTest = request.getParameter("benchTest");
            String age = request.getParameter("age");
            String pullUp = request.getParameter("pullUp");
            String skipRope = request.getParameter("skipRope");
            String sitAndReach = request.getParameter("sitAndReach");

            int sex = 0;
            if (user.getStu_Sex().equals("M")) {    //男生在公式中sex为1
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
            Middleinfo info = new Middleinfo(userID, user.getStu_Sex(), age, height, weight, bmi, bfr, pullUp, skipRope, benchTest, sitAndReach);

            try {
                Middleinfo temp = middle.queryById(userID);
                if (temp == null) {
                    middle.add(info);
                    student.setType(userID, "Middle");
                } else {
                    middle.set(info);
                    student.setType(userID, "Middle");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else if (type.equals("High")) {
            //高中生
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String benchTest = request.getParameter("benchTest");
            String age = request.getParameter("age");
            String longRun = request.getParameter("longRun");
            String throwBall = request.getParameter("throwBall");
            String sitAndReach = request.getParameter("sitAndReach");

            int sex = 0;
            if (user.getStu_Sex().equals("M")) {    //男生在公式中sex为1
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

            Highinfo high = new Highinfo(userID, user.getStu_Sex(), age, height, weight, bmi, bfr, benchTest, longRun, throwBall, sitAndReach);
            HighInfoDAO db = new HighInfoDAOImpl();
            try {
                Highinfo temp = db.queryById(userID);
                if (temp == null) {
                    db.add(high);
                    student.setType(userID, "High");
                } else {
                    db.set(high);
                    student.setType(userID, "High");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            //大学生以及研究生
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String jump = request.getParameter("jump");
            String age = request.getParameter("age");
            String longRun = request.getParameter("longRun");
            String shortRun = request.getParameter("shortRun");
            String pullUp = request.getParameter("pullUp");
            //为了计算BFR导入到数据库
            int sex = 0;
            if (user.getStu_Sex().equals("M")) {    //男生在公式中sex为1
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
            if (Double.parseDouble(jump) < 10) {
                //跳远避免错误
                int temp = (int) (Double.parseDouble(jump) * 100);
                jump = Integer.toString(temp);

            }

            //因为前端不能让用户输入自己的体脂率，所以在这里要进行一个运算，把前端传回并转换的String转化为Double类型再进行运算
            double BMI = Double.parseDouble(weight) / Double.parseDouble(height) / Double.parseDouble(height);
            double BFR = (1.2 * BMI) + (0.23 * Integer.parseInt(age)) - (10.8 * sex) - 5.4;
            DecimalFormat df = new DecimalFormat("#.00");
            String bfr = df.format(BFR);    //这里只保留两位小数
            String bmi = df.format(BMI);

            Info in = new Info(userID, user.getStu_Sex(), height, weight, jump, age, longRun, shortRun, pullUp, bfr, bmi);
            InfoDAO inf = new InfoDAOImpl();
            try {
                Info ff = inf.queryById(userID);
                if (ff == null) {            //如果该用户没有相关信息，则新建信息
                    inf.add(in);
                } else {                    //如果查询到相关信息，则进行修改
                    inf.set(in);
                }
                student.setType(userID, "university");
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        TempMassage message = new TempMassage();
        List<TempMassage> list = new ArrayList<TempMassage>();
        message.setBoolValue(true);
        message.setMessage("修改成功！");
        list.add(message);
        @SuppressWarnings("static-access")
        JSONArray jsonArray = new JSONArray().fromObject(list);
        response.getOutputStream().write((jsonArray + "").getBytes());
    }
}
