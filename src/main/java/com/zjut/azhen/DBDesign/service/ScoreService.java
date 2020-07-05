package com.zjut.azhen.DBDesign.service;

import com.zjut.azhen.DBDesign.bean.Report;
import com.zjut.azhen.DBDesign.mapping.ScoreMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreService {
    ScoreMapper scoreMapper;
    public ScoreService(ScoreMapper scoreMapper){
        this.scoreMapper=scoreMapper;
    }

    public Map<String,Float> getScoreYearsBySno(String sno){

        Map<String,Float> map=new HashMap<>();
        List<Report> list=scoreMapper.getScoreYearsBySno(sno);
        for(Report report:list){
        map.put(report.getTerm(),report.getScore());
        }
        return map;
    }

    public Map<Integer,Report> getRankedScore(String term,String mno){
        Map <Integer,Report> map=new HashMap<>();
        Integer rank=0;
        List<Report> list=scoreMapper.getRankedScore(term,mno);
        for (Report report: list
             ) {
            rank++;
            map.put(rank,report);
        }
        return map;

    }

//    public Map<Integer,Report> getRankedScore(){
//
//    }
//
//    public List<Report> getScoreById{}
}
