package com.sideprojects.MoneyCards.controller;

// import java.util.ArrayList;
import java.util.List;

// import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sideprojects.MoneyCards.dao.ScoreDao;
import com.sideprojects.MoneyCards.model.Score;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@CrossOrigin
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
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/scores", method=RequestMethod.POST)
    public Score add (@RequestBody Score score) {
        return scoreDao.createScore(score);
    }
    
    // Score getLowestScore ();
    @RequestMapping(path = "/scores/lowest", method = RequestMethod.GET)
    public Score get (){
        return scoreDao.getLowestScore();
    }
    // int deleteLowestScore ();
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/scores", method = RequestMethod.DELETE)
    public int delete (){
        return scoreDao.deleteLowestScore();
    }


}
