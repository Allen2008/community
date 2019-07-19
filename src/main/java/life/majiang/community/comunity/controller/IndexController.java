package life.majiang.community.comunity.controller;

import life.majiang.community.comunity.mapper.UserMapper;
import life.majiang.community.comunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")

    public String index(HttpServletRequest resquest){
        Cookie[] cookies = resquest.getCookies();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null){
                    resquest.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }

}
