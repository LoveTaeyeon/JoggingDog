package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Service.HealthPartService;
import edu.fjnu.Service.StudentService;
import edu.fjnu.exception.ApplicationException;
import edu.fjnu.exception.StudentException;
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

@WebServlet("/HealthEatServlet4an")
public class HealthEatServlet extends HttpServletWrapper {
    private static final long serialVersionUID = 3748439550902765441L;

    private static Logger logger = LoggerFactory.getLogger(HealthEatServlet.class);

    private static StudentService studentService = new StudentService();

    private static HealthPartService healthPartService = new HealthPartService();

    /**
     * 饮食推荐
     * - 参数要求:
     * > var1:act = getUserHealthInfo
     * > var2:userID = ?
     * - 返回结果:
     * > 以JSON的形式返回饮食推荐
     */
    public String getUserHealthInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        String userID = request.getParameter("userID");
        JSONObject jsonObj;

        try {
            if (StrKit.isBlank(userID)) {
                throw new StudentException("用户ID不能为空");
            }
            student.setStu_ID(userID);

            student = studentService.getStudentByID(student.getStu_ID());

            if (student == null) throw new StudentException("没有这个用户");

            if (StrKit.isBlank(student.getUserType())) throw new StudentException("您尚未完成信息录入");

            Map<String, String> map = healthPartService.getHealthEatInfoByStu(student);
            jsonObj = JSONObject.fromObject(map);

        } catch (StudentException var1) {
            jsonObj = new JSONObject();
            jsonObj.put("message", var1.getMessage());
            logger.debug(var1.getMessage());
        } catch (ApplicationException var2) {
            jsonObj = new JSONObject();
            jsonObj.put("message", var2.getMessage());
            logger.error(var2.getMessage());
        }
        response.getOutputStream().write(
                (jsonObj.toString()).getBytes("utf-8"));
        return "";
    }
}
