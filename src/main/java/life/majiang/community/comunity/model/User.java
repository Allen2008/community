package life.majiang.community.comunity.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String accountID;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;

//    public String getAvatarUrl() {
//        return avatarUrl;
//    }
//
//    public void setAvatarUrl(String avatarUrl) {
//        this.avatarUrl = avatarUrl;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAccountID() {
//        return accountID;
//    }
//
//    public void setAccountID(String accountID) {
//        this.accountID = accountID;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public long getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public void setGmtCreate(long gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }
//
//    public long getGmtModified() {
//        return gmtModified;
//    }
//
//    public void setGmtModified(long gmtModified) {
//        this.gmtModified = gmtModified;
//    }
}
