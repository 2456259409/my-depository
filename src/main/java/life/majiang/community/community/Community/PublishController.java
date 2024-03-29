package life.majiang.community.community.Community;

import life.majiang.community.community.Mapper.QuestionMapper;
import life.majiang.community.community.Mapper.UserMapper;
import life.majiang.community.community.model.Question;
import life.majiang.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            HttpServletRequest request,
                            Model model
                            ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(title.isEmpty()||title.equals("")){
            model.addAttribute("error","问题标题不能为空");
            return "publish";
        }
        if(description.isEmpty()||description.equals("")){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if(tag.isEmpty()||tag.equals("")){
            model.addAttribute("error","添加标签不能为空");
            return "publish";
        }
        User user =(User)request.getSession().getAttribute("user");
        if(user==null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question=new Question();
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setTitle(title);
        question.setTag(tag);
        question.setDescription(description);
        question.setCreator(user.getId());
        questionMapper.create(question);
        return "redirect:/";
    }
}
