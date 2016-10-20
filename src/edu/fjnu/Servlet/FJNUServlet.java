package edu.fjnu.Servlet;


import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.PlanForUserDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.PlanForUserDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.DAOImpl.UserHavePlanDAOImpl;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.Entity.UsersInformation.PlanForUser;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.UsersInformation.UserHavePlan;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import edu.fjnu.Entity.Usual.TestBodyFatTemp;
import edu.fjnu.Service.LoginAndRegister;
import edu.fjnu.Service.Temp;
import edu.fjnu.Service.Translater.HighTranslate;
import edu.fjnu.Service.Translater.MiddleTranslate;
import edu.fjnu.Service.Translater.PrimaryTranslate;
import edu.fjnu.Service.Translater.Translater;
import edu.fjnu.getPlan.GetPlanForPeople;
import edu.fjnu.getPlan.HighGetPlan;
import edu.fjnu.getPlan.MiddleGetPlan;
import edu.fjnu.getPlan.PrimaryGetPlan;
import edu.fjnu.utils.MD5;
import edu.fjnu.utils.StrKit;
import edu.fjnu.webCrawlers.Crawlers;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FJNUServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.getLogger(FJNUServlet.class);

    public FJNUServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        String register = "Register";        //负责标记注册页面
        String login = "Login";                //负责标记登陆页面
        String changeBody = "ChangeBody";   //负责标记修改体测信息界面
        String sendPlan = "SendPlan";        //负责标记方案推送的界面
        String testBodyFat = "TestBodyFat"; //负责标记查看身体信息界面
        String getCodoon = "GetCodoon";        //绑定咕咚账号的界面
        LoginAndRegister log = new LoginAndRegister();
        //对不同的界面做不同的servlet反应

        if (register.equals(page)) {
            String name = request.getParameter("name");
            String number = request.getParameter("number");
            //number是用户名。因为避免太多的修改，所以现在用number代表用户名
            String firstPassword = request.getParameter("firstPassword");
            String secondpassword = request.getParameter("secondPassword");
            String sex = request.getParameter("sex");

            try {
                if (StrKit.isBlank(number)) {
                    Temp t = new Temp("请输入你的用户名！", 3);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (StrKit.isBlank(name)) {
                    Temp t = new Temp("请输入你的姓名！", 3);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (StrKit.isBlank(firstPassword)) {
                    Temp t = new Temp("请输入你的密码！", 3);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (StrKit.isBlank(secondpassword)) {
                    Temp t = new Temp("请输入你的确认密码！", 3);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (StrKit.isBlank(sex)) {
                    Temp t = new Temp("请输入你的性别！", 3);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }

                if (log.isExist(number)) {    //查询是否存在该用户，存在则给前端存在信息
                    Temp t = new Temp("该用户已存在！", 1);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();

                } else {
                    //如果不存在，而且两次密码输入无误，则新建用户，并给前端创建成功信息
                    if (log.isSamePassword(firstPassword, secondpassword)) {
                        //机制修改错误机制，给用户更好地使用体验
                        //System.out.println(sex);
                        if (sex.equals("女")) {
                            sex = "F";
                        } else if (sex.equals("男")) {
                            sex = "M";
                        }
                        //System.out.println(sex);
                        log.setStudent(number, name, MD5.GetMD5Code(firstPassword), sex);
                        Temp t = new Temp("注册成功！", 2);
                        List<Temp> tt = new ArrayList<Temp>();
                        tt.add(t);
                        String jsonData = JSONArray.fromObject(tt).toString();
                        out.write(jsonData);
                        out.close();
                    } else {                        //如果两次密码输入不一致，则给用户重新输入的提醒
                        Temp t = new Temp("请检查您的密码输入！", 3);
                        List<Temp> tt = new ArrayList<Temp>();
                        tt.add(t);
                        String jsonData = JSONArray.fromObject(tt).toString();
                        out.write(jsonData);
                        out.close();
                    }
                }
            } catch (SQLException | NoSuchAlgorithmException e) {
                logger.error(e.getMessage());
            }
        } else if (login.equals(page)) {
            String ID = request.getParameter("number");
            String password = request.getParameter("password");
            try {

                if (StrKit.isBlank(ID)) {
                    Temp t = new Temp("请输入用户名！", 2);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (StrKit.isBlank(ID)) {
                    Temp t = new Temp("请输入密码！", 2);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (!log.isExist(ID)) {
                    Temp t = new Temp("该用户不存在！", 2);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                    return;
                }
                if (log.judgePassword(ID, MD5.GetMD5Code(password))) {        //密码正确，给前端成功提醒
                    Temp t = new Temp("登录成功！", 1);
                    request.getSession().setAttribute("userid", ID);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                } else {                                        //密码不正确，给前端不正确提醒
                    Temp t = new Temp("密码不正确！", 2);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                }

            } catch (SQLException | NoSuchAlgorithmException e) {
                logger.error(e.getMessage());
            }

        } else if (changeBody.equals(page)) {

//			String stuID = request.getParameter("stuNumber");
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String jump = request.getParameter("jump");
            String age = request.getParameter("age");
            String longRun = request.getParameter("longRun");
            String shortRun = request.getParameter("shortRun");
            String pullUp = request.getParameter("pullUp");
            String type = request.getParameter("type");
            //String pulmonary = request.getParameter("pulmonary");
            String stuID = (String) request.getSession().getAttribute("userid");
            //为了计算BFR导入到数据库
            StudentDAO stu = new StudentDAOImpl();
            Student student = new Student();
            try {
                student = stu.queryById(stuID);
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

            Info in = new Info(stuID, student.getStu_Sex(), height, weight, jump, age, longRun, shortRun, pullUp, bfr, bmi);
            InfoDAO inf = new InfoDAOImpl();
            try {
                Info ff = inf.queryById(stuID);
                if (ff == null) {            //如果该用户没有相关信息，则新建信息
                    inf.add(in);
                } else {                    //如果查询到相关信息，则进行修改
                    inf.set(in);
                }
                stu.setType(stuID, type);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }


        } else if (sendPlan.equals(page)) {

            String userID = (String) request.getSession().getAttribute("userid");
            UserHavePlanDAO userHave = new UserHavePlanDAOImpl();
            UserHavePlan uu = new UserHavePlan();
            try {
                uu = userHave.queryById(userID);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            if (uu == null || uu.getHave_Plan() == 0) {
                //待完成
                if (uu == null) {
                    try {
                        userHave.add(new UserHavePlan(userID, 0));
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                    }
                }

                StudentDAO stu = new StudentDAOImpl();
                Student user = new Student();
                try {
                    user = stu.queryById(userID);
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
                List<HealthPlan> jsonList = new ArrayList<HealthPlan>();
//				String userType = user.getUserType();
//				System.out.println(userType);
//				System.out.println(user);
                if (user.getUserType().equals("Primary")) {
                    List<HealthPlan> FVC = new ArrayList<HealthPlan>();
                    List<HealthPlan> sitAndReach = new ArrayList<HealthPlan>();
                    List<HealthPlan> skipRope = new ArrayList<HealthPlan>();
                    List<HealthPlan> shortRun = new ArrayList<HealthPlan>();
                    //List<HealthPlan> everyBody = new ArrayList<HealthPlan>();
                    PrimaryTranslate trans = new PrimaryTranslate();
                    FVC = PrimaryGetPlan.getPlan(userID, "肺活量", "不及格至优秀");
                    sitAndReach = PrimaryGetPlan.getPlan(userID, "坐立体前屈", trans.translateSitAndReach(userID));
                    skipRope = PrimaryGetPlan.getPlan(userID, "跳绳", trans.translateSkipRope(userID));
                    shortRun = PrimaryGetPlan.getPlan(userID, "50m跑", trans.translateShortrun(userID));
                    //everyBody = GetPlanForPeople.getPlan(userID,"核心肌群",trans.translateLongrun(userID));
                    jsonList.addAll(FVC);
                    jsonList.addAll(shortRun);
                    jsonList.addAll(skipRope);
                    jsonList.addAll(sitAndReach);
                    String jsonData = JSONArray.fromObject(jsonList).toString();
                    out.write(jsonData);
                    //out.write(userType);
                    out.close();
                } else if (user.getUserType().equals("Middle")) {
                    List<HealthPlan> pullUp = new ArrayList<HealthPlan>();
                    List<HealthPlan> skipRope = new ArrayList<HealthPlan>();
                    List<HealthPlan> benchTest = new ArrayList<HealthPlan>();
                    List<HealthPlan> sitAndReach = new ArrayList<HealthPlan>();
                    //List<HealthPlan> everyBody = new ArrayList<HealthPlan>();
                    MiddleTranslate trans = new MiddleTranslate();
                    pullUp = MiddleGetPlan.getPlan(userID, "引体向上", trans.translatePullUp(userID));
                    skipRope = MiddleGetPlan.getPlan(userID, "跳绳", trans.translateSkipRope(userID));
                    benchTest = MiddleGetPlan.getPlan(userID, "台阶测试", trans.translateBenchTest(userID));
                    sitAndReach = MiddleGetPlan.getPlan(userID, "坐立体前屈", trans.translateSitAndReach(userID));
                    //everyBody = GetPlanForPeople.getPlan(userID,"核心肌群",trans.translateLongrun(userID));
                    jsonList.addAll(pullUp);
                    jsonList.addAll(skipRope);
                    jsonList.addAll(benchTest);
                    jsonList.addAll(sitAndReach);
                    String jsonData = JSONArray.fromObject(jsonList).toString();
                    out.write(jsonData);
                    out.close();
                } else if (user.getUserType().equals("High")) {
                    List<HealthPlan> benchTest = new ArrayList<HealthPlan>();
                    List<HealthPlan> longRun = new ArrayList<HealthPlan>();
                    List<HealthPlan> throwBall = new ArrayList<HealthPlan>();
                    List<HealthPlan> sitAndReach = new ArrayList<HealthPlan>();
                    //List<HealthPlan> everyBody = new ArrayList<HealthPlan>();
                    HighTranslate trans = new HighTranslate();
                    benchTest = HighGetPlan.getPlan(userID, "引体向上", trans.translateThrowBall(userID));
                    //不合理，资料需要再收集
                    longRun = HighGetPlan.getPlan(userID, "1000米长跑、台阶测试", trans.translateLongRun(userID));
                    throwBall = HighGetPlan.getPlan(userID, "实心球", trans.translateThrowBall(userID));
                    sitAndReach = HighGetPlan.getPlan(userID, "坐体前屈", trans.translateSitAndReach(userID));
                    //everyBody = GetPlanForPeople.getPlan(userID,"核心肌群",trans.translateLongrun(userID));
                    jsonList.addAll(benchTest);
                    jsonList.addAll(longRun);
                    jsonList.addAll(throwBall);
                    jsonList.addAll(sitAndReach);
                    String jsonData = JSONArray.fromObject(jsonList).toString();
                    out.write(jsonData);
                    out.close();
                } else {
                    List<HealthPlan> longRun = new ArrayList<HealthPlan>();
                    List<HealthPlan> jump = new ArrayList<HealthPlan>();
                    List<HealthPlan> pullUp = new ArrayList<HealthPlan>();
                    List<HealthPlan> shortRun = new ArrayList<HealthPlan>();
                    List<HealthPlan> everyBody = new ArrayList<HealthPlan>();
                    Translater trans = new Translater();
                    longRun = GetPlanForPeople.getPlan(userID, "1000米长跑", trans.translateLongrun(userID));
                    jump = GetPlanForPeople.getPlan(userID, "立定跳远", trans.translateJump(userID));
                    pullUp = GetPlanForPeople.getPlan(userID, "引体向上", trans.translatePullup(userID));
                    shortRun = GetPlanForPeople.getPlan(userID, "50米短跑", trans.translateShortrun(userID));
                    everyBody = GetPlanForPeople.getPlan(userID, "核心肌群", trans.translateLongrun(userID));
//					System.out.println(longRun.size());
//					System.out.println(jump.size());
//					System.out.println(pullUp.size());
//					System.out.println(shortRun.size());
//					System.out.println(everyBody.size());
                    jsonList.addAll(longRun);
                    jsonList.addAll(jump);
                    jsonList.addAll(pullUp);
                    jsonList.addAll(shortRun);
                    jsonList.addAll(everyBody);

                    String jsonData = JSONArray.fromObject(jsonList).toString();
                    out.write(jsonData);
                    out.close();
                }
            } else {
                //里面有用户的方案
                PlanForUserDAO pfu = new PlanForUserDAOImpl();
                List<PlanForUser> list = new ArrayList<PlanForUser>();
                try {
                    list = pfu.queryByUserID(userID);
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
                List<HealthPlan> tempList = new ArrayList<HealthPlan>();
                for (int i = 0; i < list.size(); i++) {
                    PlanForUser pp = list.get(i);
                    HealthPlan h = new HealthPlan(pp.getPfu_name(), pp.getPfu_level(), pp.getPfu_exercisepart(), pp.getPfu_hardlevel(), pp.getPfu_groupnum(), pp.getPfu_forwhat());
                    tempList.add(h);
                }
                String jsonData = JSONArray.fromObject(tempList).toString();
                out.write(jsonData);
                out.close();
            }

        } else if (testBodyFat.equals(page)) {
            String stuID = (String) request.getSession().getAttribute("userid");
//			String ID = request.getParameter("stuNumber");
//			InfoDAO inf = new InfoDAOImpl();
            stu_CodoonDAO stu = new stu_CodoonDAOImpl();
            stu_Codoon sc = new stu_Codoon();
            try {
                sc = stu.queryById(stuID);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            //把给前端的数据封装到TestBodyFatTemp类中在传递给前端
            TestBodyFatTemp temp = new TestBodyFatTemp();
            try {
                //调用函数，完成封装
                temp = Crawlers.getTemp(stuID, sc.getC_username(), sc.getC_password());
            } catch (SQLException e1) {
                logger.error(e1.getMessage());
            }
            List<TestBodyFatTemp> tempList = new ArrayList<TestBodyFatTemp>();
            tempList.add(temp);
            String jsonData = JSONArray.fromObject(tempList).toString();
            out.write(jsonData);
            out.close();

        } else if (getCodoon.equals(page)) {

            String userID = (String) request.getSession().getAttribute("userid");
            String number = request.getParameter("number");
            String firstPassword = request.getParameter("firstPassword");
            String secondPassword = request.getParameter("secondPassword");
//			String type = request.getParameter("type");

            if (log.isSamePassword(firstPassword, secondPassword)) {    //密码输入正确就存到数据库中
                stu_CodoonDAO stu = new stu_CodoonDAOImpl();
                stu_Codoon test = new stu_Codoon();
                try {
                    test = stu.queryById(userID);
                } catch (SQLException e1) {
                    logger.error(e1.getMessage());
                }
                if (test != null) {
                    //如果数据库中存在该用户的绑定信息，则修改绑定
                    stu_Codoon s = new stu_Codoon(userID, number, firstPassword);
                    try {
                        stu.set(s);
                        System.out.println("修改绑定成功！");
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                    }
                    Temp t = new Temp("修改绑定成功！", 0);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                } else {
                    //如果数据库中不存在绑定信息，则进行绑定
                    stu_Codoon s = new stu_Codoon(userID, number, firstPassword);
                    try {
                        stu.add(s);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                    }
                    Temp t = new Temp("绑定成功！", 0);
                    List<Temp> tt = new ArrayList<Temp>();
                    tt.add(t);
                    String jsonData = JSONArray.fromObject(tt).toString();
                    out.write(jsonData);
                    out.close();
                }
            } else {
                //密码输入不一致则不进行操作，给用户返回输入不一致信息
                Temp t = new Temp("两次密码输入不一致！", 0);
                List<Temp> tt = new ArrayList<Temp>();
                tt.add(t);
                String jsonData = JSONArray.fromObject(tt).toString();
                out.write(jsonData);
                out.close();
            }
        }
    }
}
