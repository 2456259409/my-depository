package life.majiang.community.community.Community;

import life.majiang.community.community.dto.PageinationDTO;
import life.majiang.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
    @Autowired
    QuestionService questionService;
    @GetMapping("/")
    public String middle(Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                         @RequestParam(name = "size",defaultValue = "5")Integer size){
        PageinationDTO pageination=questionService.list(page,size);
        model.addAttribute("pageination",pageination);
        return "index";
    }
}
