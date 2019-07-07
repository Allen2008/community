package life.majiang.community.comunity.dto;

public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private  String code;
    private String state;
    private String  Redirect_url;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRedirect_url() {
        return Redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        Redirect_url = redirect_url;
    }
}
