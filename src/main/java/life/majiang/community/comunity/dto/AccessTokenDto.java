package life.majiang.community.comunity.dto;

import lombok.Data;

@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private  String code;
    private String state;
    private String  Redirect_url;

}
