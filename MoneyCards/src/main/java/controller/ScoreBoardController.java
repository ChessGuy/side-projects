package controller;

import dao.ScoreDao;
import model.Score;

import java.util.List;

public class ScoreBoardController {

    private final ScoreDao scoreDao;
    public ScoreBoardController (ScoreDao scoreDao){
        this.scoreDao = scoreDao;
    }
}
