package bean;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户类JavaBean
 * @date 2021-12-08 21:45:39
 */
public class User {
    private String name;
    private String password;
    private String sex;
    private String number;
    private int admin;//权限
    private int identity;//身份 1：老师 0：同学

    public User(String name, String password, String sex, String number, int admin, int identity) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.number = number;
        this.admin = admin;
        this.identity = identity;
    }

    /**
     * @Description: 返回构造对象时候需要使用
     * @Author: BaiYZ
     * @Date: 2021/12/8 22:22
     * @return: null
     */
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", number='" + number + '\'' +
                ", admin=" + admin +
                ", identity=" + identity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}