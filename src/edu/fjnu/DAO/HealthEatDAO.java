package edu.fjnu.DAO;

import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.Usual.HealthEat;

/**
 * Created by ven_hxz on 16/4/3.
 * 饮食健康推荐DAO
 */
public abstract class HealthEatDAO {
    public abstract HealthEat findHealthEatInfoByUser(Student student, String healthType)
            throws Exception;

    public abstract String getStudentType(Student student) throws Exception;
}
