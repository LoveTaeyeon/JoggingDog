package edu.fjnu.Service;

import edu.fjnu.DAO.HealthEatDAO;
import edu.fjnu.DAOImpl.HealthEatDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.exception.HealthEatException;
import edu.fjnu.utils.StrKit;
import edu.fjnu.utils.UserTypeConvert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ven_hxz on 16/4/3.
 * 饮食健康推荐业务处理
 */
public class HealthPartService {
    private static final String LOW_FAT = "低脂";

    private static final String IMPROVE_BRAIN = "健脑";

    private static final String STRONG_MUSCLE = "增肌";

    private static final String ENRICH_BLOOD = "补血";

    public static String[] AGE_PART_ARR = {"primary", "middle", "high", "university"};

    private HealthEatDAO healthEatDAO = new HealthEatDAOImpl();

    /**
     * 根据学生类型得到相应的饮食推荐信息
     *
     * @param student 学生
     * @return 饮食推荐信息
     * @throws Exception
     */
    public Map<String, String> getHealthEatInfoByStu(Student student) throws HealthEatException {
        Map<String, String> healthEatMap = new HashMap<>();

        try {
            /*
            如果用户类型不为空,使用之前随机的一个用户类型;
            如果为空,则查询用户的类型;
            转换用户类型:student.userType -> healtheat.agePart
             */
            if (StrKit.isBlank(student.getUserType())) {
                student.setUserType(healthEatDAO.getStudentType(student));
            }

            student.setUserType(UserTypeConvert.convertUserType(student.getUserType()));

            healthEatMap.put("low_fat", healthEatDAO.findHealthEatInfoByUser(student, LOW_FAT).getPassage());
            healthEatMap.put("improve_brain", healthEatDAO.findHealthEatInfoByUser(student, IMPROVE_BRAIN).getPassage());
            healthEatMap.put("strong_muscle", healthEatDAO.findHealthEatInfoByUser(student, STRONG_MUSCLE).getPassage());
            healthEatMap.put("enrich_blood", healthEatDAO.findHealthEatInfoByUser(student, ENRICH_BLOOD).getPassage());
        } catch (HealthEatException e) {
            throw new HealthEatException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new HealthEatException("未知错误");
        }

        return healthEatMap;
    }
}
