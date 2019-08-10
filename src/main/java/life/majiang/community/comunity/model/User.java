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

}
