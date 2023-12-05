package bean;

/**
 * @Description 用户
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class User {
    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 管理员表示 1是管理员，默认是0 */
    private char admin;

    /** 余额 */
    private Double balance;

    public User() {
    }

    public User(String username, String password) {
        this(username, password, '0');
    }

    public User(String username, String password, char admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getAdmin() {
        return admin;
    }

    public void setAdmin() {
        this.admin = admin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
