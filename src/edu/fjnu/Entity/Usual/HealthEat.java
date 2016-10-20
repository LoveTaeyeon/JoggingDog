package edu.fjnu.Entity.Usual;

/**
 * Created by ven_hxz on 16/4/3.
 * 饮食健康推荐信息bean
 */
public class HealthEat {
    private String info_id;//分类ID
    private String agePart;//年龄分段(小学生,初中生,高中生,大学生,研究生)
    private String passage;//推荐信息
    private String healthType;//体质类型(低脂,健脑,增肌,补血)

    public HealthEat() {
    }

    public HealthEat(String info_id, String agePart, String passage, String healthType) {
        this.info_id = info_id;
        this.agePart = agePart;
        this.passage = passage;
        this.healthType = healthType;
    }

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public String getAgePart() {
        return agePart;
    }

    public void setAgePart(String agePart) {
        this.agePart = agePart;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    public String getHealthType() {
        return healthType;
    }

    public void setHealthType(String healthType) {
        this.healthType = healthType;
    }

    @Override
    public String toString() {
        return "HealthEat{" +
                "info_id='" + info_id + '\'' +
                ", agePart='" + agePart + '\'' +
                ", passage='" + passage + '\'' +
                ", healthType='" + healthType + '\'' +
                '}';
    }
}
