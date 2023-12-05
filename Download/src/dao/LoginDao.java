package dao;

import bean.User;

import java.util.ArrayList;

/**
 * @Description 登录的数据处理
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class LoginDao {
    public static User loginedUser;
    private ArrayList<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("admin", "123456",'1'));
        users.add(new User("Tom", "123456"));
        users.add(new User("Jack", "987654321"));
        users.add(new User("张三", "112233", '1'));
    }

    public static void setLoginedUser(User loginedUser) {
        LoginDao.loginedUser = loginedUser;
    }

    public static User getLoginedUser() {
        return loginedUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
