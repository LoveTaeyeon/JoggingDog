package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.PlanForUserDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.DAOImpl.PlanForUserDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.DAOImpl.UserHavePlanDAOImpl;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.PlanForUser;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.UsersInformation.UserHavePlan;
import edu.fjnu.Service.Translater.HighTranslate;
import edu.fjnu.Service.Translater.MiddleTranslate;
import edu.fjnu.Service.Translater.PrimaryTranslate;
import edu.fjnu.Service.Translater.Translater;
import edu.fjnu.getPlan.GetPlanForPeople;
import edu.fjnu.getPlan.HighGetPlan;
import edu.fjnu.getPlan.MiddleGetPlan;
import edu.fjnu.getPlan.PrimaryGetPlan;
import edu.fjnu.utils.HttpServletWrapper;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidHealthPlanServlet extends HttpServletWrapper {

    private static final long serialVersionUID = 8435546286123472070L;

    private static Logger logger = LoggerFactory.getLogger(AndroidHealthPlanServlet.class);

    /**
     * 安卓获取健身方案推荐
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getHealthPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
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
                JSONArray jsonArray = new JSONArray().fromObject(jsonList);
                response.getOutputStream().write((jsonArray + "").getBytes());
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
                JSONArray jsonArray = new JSONArray().fromObject(jsonList);
                response.getOutputStream().write((jsonArray + "").getBytes());
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
                jsonList.addAll(benchTest);
                jsonList.addAll(longRun);
                jsonList.addAll(throwBall);
                jsonList.addAll(sitAndReach);
                JSONArray jsonArray = new JSONArray().fromObject(jsonList);
                response.getOutputStream().write((jsonArray + "").getBytes());
            } else if (user.getUserType().equals("university")) {
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
                jsonList.addAll(longRun);
                jsonList.addAll(jump);
                jsonList.addAll(pullUp);
                jsonList.addAll(shortRun);
                jsonList.addAll(everyBody);
                JSONArray jsonArray = new JSONArray().fromObject(jsonList);
                response.getOutputStream().write((jsonArray + "").getBytes());
            } else {
                TempMassage message = new TempMassage();
                message.setMessage("您还未完成信息的录入！请去完成信息的录入！");
                message.setBoolValue(false);
                List<TempMassage> list = new ArrayList<TempMassage>();
                list.add(message);
                JSONArray jsonArray = new JSONArray().fromObject(list);
                response.getOutputStream().write((jsonArray + "").getBytes());
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
            JSONArray jsonArray = new JSONArray().fromObject(tempList);
            response.getOutputStream().write((jsonArray + "").getBytes());
        }
    }
}
