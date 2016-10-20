package edu.fjnu.Servlet;

import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.Usual.HealthPassage;
import edu.fjnu.Service.HealthPartService;
import edu.fjnu.Service.HealthPassageService;
import edu.fjnu.Service.StudentService;
import edu.fjnu.exception.ApplicationException;
import edu.fjnu.exception.HealthEatException;
import edu.fjnu.exception.HealthPassageException;
import edu.fjnu.utils.HttpServletWrapper;
import edu.fjnu.utils.StrKit;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import static edu.fjnu.Service.HealthPartService.AGE_PART_ARR;

/**
 * Created by ven_hxz on 16/4/3.
 * 饮食推荐模块
 */
@WebServlet("/ShowHealthInfoServlet")
public class ShowHealthInfoServlet extends HttpServletWrapper {
    private static HealthPartService healthPartService = new HealthPartService();

    private static HealthPassageService healthPassageService = new HealthPassageService();

    private static StudentService studentService = new StudentService();

    private Logger logger = LoggerFactory.getLogger(ShowHealthInfoServlet.class);

    /**
     * 展示首页健康信息模块
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String toShowIndexHealthInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObj;
        try {
            Map<String, HealthPassage> healthPassageMap = healthPassageService.getIndexHealthPassage();
            jsonObj = JSONObject.fromObject(healthPassageMap);
        } catch (HealthPassageException e) {
            jsonObj = new JSONObject();
            jsonObj.put("message", e.getMessage());
            logger.error(e.getMessage());
        }

        response.getOutputStream().write(
                (jsonObj.toString()).getBytes("utf-8"));
        return "";
    }

    /**
     * 饮食推荐相关信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String toShowHealthPlan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject jsonObj;
        Map<String, String> healthEatMap;
        Student student = new Student();

        String studentName = (String) request.getSession().getAttribute("session_user");

        try {
            /*
            如果session中没有用户,则随机出一个类型并查找出结果
            否则根据用户的类型进行判断当前用户的所属学习阶段,获取相关信息
             */
            if (StrKit.isBlank(studentName)) {
                String userType = AGE_PART_ARR[new Random().nextInt(AGE_PART_ARR.length)];
                student.setUserType(userType);

                healthEatMap = healthPartService.getHealthEatInfoByStu(student);
            } else {
                student.setName(studentName);
                student = studentService.getStudentByName(student.getName());
                healthEatMap = healthPartService.getHealthEatInfoByStu(student);
            }

            jsonObj = JSONObject.fromObject(healthEatMap);

        } catch (HealthEatException e) {
            jsonObj = new JSONObject();
            jsonObj.put("message", e.getMessage());
            logger.error(e.getMessage());
        } catch (ApplicationException e) {
            jsonObj = new JSONObject();
            jsonObj.put("message", e.getMessage());
            logger.error(e.getMessage());
        }
        response.getOutputStream().write(
                (jsonObj.toString()).getBytes("utf-8"));
        return "";
    }


}
