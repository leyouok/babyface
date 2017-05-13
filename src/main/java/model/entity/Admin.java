package model.entity;

/**
 * Created by blog.91zen.com on 2017/5/12.
 */
public class Admin {
    private Integer id;
    private String adminName;
    private String adminPw;

    public Admin() {
    }

    public Admin(Integer id, String adminName, String adminPw) {
        this.id = id;
        this.adminName = adminName;
        this.adminPw = adminPw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }
}
