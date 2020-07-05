package com.zjut.azhen.DBDesign.controllers.scores;

import com.zjut.azhen.DBDesign.bean.Report;
import com.zjut.azhen.DBDesign.bean.RespBean;
import com.zjut.azhen.DBDesign.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * TODO: 1)学生成绩按每学年进行成绩统计；
         2)学生成绩名次排定；
         4)学生成绩查询；
         5)输入每个学生成绩时，自动生成该学生已修总学分；
 * */

/**
 * @author asus
 */
@RestController
public class ScoreController {
    private final ScoreService scoreService;
    public ScoreController(ScoreService scoreService){
        this.scoreService=scoreService;
    }

    /**
     * @return 学生成绩按每学年进行成绩统计；
     */
        @GetMapping("/score/year/{sno}")
        public RespBean getScoreYearsBySno(@PathVariable String sno){
            return RespBean.ok("success",scoreService.getScoreYearsBySno(sno)); }

        @GetMapping("score/rank/{term}/{mno}")
        public RespBean getRankedScore(@PathVariable String term,@PathVariable String mno){
        if(mno==null){
            return RespBean.error("Parameter Error",mno);
        }
            return RespBean.ok("success",scoreService.getRankedScore(term,mno));

        }
}


