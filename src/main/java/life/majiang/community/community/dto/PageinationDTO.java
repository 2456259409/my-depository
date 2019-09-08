package life.majiang.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PageinationDTO {
    private List<QuestionDTO> questionDTOS;
    private boolean showPrevious;
    private boolean showFirstpage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;
    private Integer totalPage;
    public void setPageination(Integer totalCount, Integer page, Integer size) {
        pages=new ArrayList<>();
        this.page=page;
        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }
        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }
        if(page==1){
            showPrevious=false;
        }else{
            showPrevious=true;
        }
        if(totalPage==page){
            showNext=false;
        }else{
            showNext=true;
        }
        if(pages.contains(1)){
            showFirstpage=false;
        }else{
            showFirstpage=true;
        }
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else{
            showEndPage=true;
        }
    }
}
