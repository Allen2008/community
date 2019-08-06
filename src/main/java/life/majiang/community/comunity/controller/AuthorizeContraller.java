package life.majiang.community.comunity.controller;

import life.majiang.community.comunity.dto.AccessTokenDto;
import life.majiang.community.comunity.dto.GithubUser;
import life.majiang.community.comunity.mapper.UserMapper;
import life.majiang.community.comunity.model.User;
import life.majiang.community.comunity.provider.GithubProvider;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                            HttpServletResponse response){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("460b4b947861184a127c");
        accessTokenDto.setClient_secret("0f8856c28aa247ff20f9ac45c3308acf70a9cf2e");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url("http://127.0.0.1:8888/callback");
        accessTokenDto.setState(state);
        //githubProvider.getAccessToken(accessTokenDto);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        System.out.println("accessToken :" +accessToken);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        if(githubUser!= null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountID(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            System.out.println(githubUser.getAvatarUrl());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            //登录成功，写cookie和session

           request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }
    }
}
