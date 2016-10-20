package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Service.LoginAndRegister;
import edu.fjnu.utils.MD5;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidRegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 5349745936579910018L;

    private static Logger logger = LoggerFactory.getLogger(AndroidRegisterServlet.class);

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
        String userID = request.getParameter("userID");
        String firstPassword = request.getParameter("firstPassword");
        String secondPassword = request.getParameter("secondPassword");
        String sex = request.getParameter("sex");
        String name = request.getParameter("name");
        LoginAndRegister log = new LoginAndRegister();

        try {
            if (log.isExist(userID)) {        //查询是否存在该用户，存在则给前端存在信息
                TempMassage message = new TempMassage();
                message.setBoolValue(false);
                message.setMessage("该用户已存在！");
                List<TempMassage> tt = new ArrayList<TempMassage>();
                tt.add(message);
                @SuppressWarnings("static-access")
                JSONArray jsonArray = new JSONArray().fromObject(tt);
                response.getOutputStream().write((jsonArray + "").getBytes());
            } else {                            //如果不存在，而且两次密码输入无误，则新建用户，并给前端创建成功信息
                if (log.isSamePassword(firstPassword, secondPassword)) {
                    //机制修改错误机制，给用户更好地使用体验
                    if (sex.equals("男")) {
                        sex = "M";
                    } else if (sex.equals("女")) {
                        sex = "F";
                    }
                    log.setStudent(userID, name, MD5.GetMD5Code(firstPassword), sex);
                    TempMassage message = new TempMassage();
                    message.setBoolValue(true);
                    message.setMessage("注册成功！为您跳转到登陆界面！");
                    List<TempMassage> tt = new ArrayList<TempMassage>();
                    tt.add(message);
                    @SuppressWarnings("static-access")
                    JSONArray jsonArray = new JSONArray().fromObject(tt);
                    response.getOutputStream().write((jsonArray + "").getBytes());
                } else {                        //如果两次密码输入不一致，则给用户重新输入的提醒
                    TempMassage message = new TempMassage();
                    message.setBoolValue(false);
                    message.setMessage("两次密码输入不一致！！");
                    List<TempMassage> tt = new ArrayList<TempMassage>();
                    tt.add(message);
                    @SuppressWarnings("static-access")
                    JSONArray jsonArray = new JSONArray().fromObject(tt);
                    response.getOutputStream().write((jsonArray + "").getBytes());
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
    }
}
