/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import com.renory.model.entity.evaluate.Evaluate;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class Evaluating {
    private ArrayList<Evaluate> evaluating = new ArrayList();
    
    public void add(int userId, int rating){
        Evaluate evaluate = new Evaluate();
        evaluate.setUserId(userId);
        evaluate.setRating(rating);
        evaluate.setTime(System.currentTimeMillis());
        evaluating.add(evaluate);
    }

    public ArrayList<Evaluate> getEvaluating() {
        return evaluating;
    }

    public void setEvaluating(ArrayList<Evaluate> evaluating) {
        this.evaluating = evaluating;
    }
    
    
}
