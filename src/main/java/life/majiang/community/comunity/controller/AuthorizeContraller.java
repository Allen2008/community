package life.majiang.community.comunity.controller;

import life.majiang.community.comunity.dto.AccessTokenDto;
import life.majiang.community.comunity.dto.GithubUser;
import life.majiang.community.comunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeContraller {

    @Autowired
    private GithubProvider githubProvider;
//
//    @Value("${github.client.id}")
//    private String clientID;
//    @Value("{github.client.secret}")
//    private String clientSecret;
//    @Value("{github.rederect.url}")
//    private String clientRedirectURL;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("460b4b947861184a127c");
        accessTokenDto.setClient_secret("0f8856c28aa247ff20f9ac45c3308acf70a9cf2e");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url("http://127.0.0.1:8888/callback");
        accessTokenDto.setState(state);
        githubProvider.getAccessToken(accessTokenDto);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user!= null){
            //登录成功，写cookie和session
            request.getSession().setAttribute("user",user);
            return "redirect:index";
        }else {
            //登录失败
            return "redirect:index";
        }
    }
}
