package life.majiang.community.comunity.controller;
import life.majiang.community.comunity.dto.QuestionDTO;
import life.majiang.community.comunity.mapper.QuestionMapper;
import life.majiang.community.comunity.mapper.UserMapper;
import life.majiang.community.comunity.model.Question;
import life.majiang.community.comunity.model.User;
import life.majiang.community.comunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")

    public String index(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
       if(cookies!=null){
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
  }
        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("questions" ,questionDTOList);
        return "index";
    }

}
