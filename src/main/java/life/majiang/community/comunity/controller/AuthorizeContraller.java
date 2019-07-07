package life.majiang.community.comunity.controller;

import life.majiang.community.comunity.dto.AccessTokenDto;
import life.majiang.community.comunity.dto.GithubUser;
import life.majiang.community.comunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeContraller {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("460b4b947861184a127c");
        accessTokenDto.setClient_secret("0f8856c28aa247ff20f9ac45c3308acf70a9cf2e");
        accessTokenDto.setCode(code);
        accessTokenDto.setClient_secret("http://127.0.0.1:8888/callback");
        accessTokenDto.setState(state);
        githubProvider.getAccessToken(accessTokenDto);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        //System.out.println(user.getName());
        return "index";
    }
}
