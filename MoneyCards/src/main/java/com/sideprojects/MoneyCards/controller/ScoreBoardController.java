package com.sideprojects.MoneyCards.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sideprojects.MoneyCards.dao.ScoreDao;
import com.sideprojects.MoneyCards.model.Score;


@RestController
public class ScoreBoardController {

    private final ScoreDao scoreDao;
    
    public ScoreBoardController (ScoreDao scoreDao){
        this.scoreDao = scoreDao;
    }

    // List<Score> getScores ();
    @RequestMapping(path = "/scores", method = RequestMethod.GET)
    public List<Score> list (){
        return scoreDao.getScores();
    }

    // Score getScoreById (int scoreId);
    @RequestMapping(path = "/scores/{id}", method = RequestMethod.GET)
    public Score get (@PathVariable int id){
        return scoreDao.getScoreById(id);
    }

    // Score createScore (Score score);

    // Score getLowestScore ();
    @RequestMapping(path = "/scores/lowest", method = RequestMethod.GET)
    public Score get (){
        return scoreDao.getLowestScore();
    }

    // int deleteLowestScore ();



}
