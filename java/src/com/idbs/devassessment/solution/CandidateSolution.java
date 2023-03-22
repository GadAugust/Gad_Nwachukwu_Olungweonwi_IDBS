/*
 * Copyright (C) 1993-2020 ID Business Solutions Limited
 * All rights reserved
 */
package com.idbs.devassessment.solution;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.idbs.devassessment.core.IDBSSolutionException;
import com.idbs.devassessment.core.DifficultyLevel;
import com.idbs.devassessment.harness.DigitalTaxTracker;

/**
 * Example solution for the example question
 */

public class CandidateSolution extends AssessmentSolutionBase
{
    @Override
    public DifficultyLevel getDifficultyLevel()
    {
        /*
         * 
         * CHANGE this return type to YOUR selected choice of difficulty level to which you will code an answer to.
         * 
         */

        //return DifficultyLevel.IDBS_EXAMPLE;
        //return DifficultyLevel.LEVEL_1;
        //return DifficultyLevel.LEVEL_2;
        return DifficultyLevel.LEVEL_3;
    }

    @Override
    public String getAnswer() throws IDBSSolutionException
    {
        String json = getDataForQuestion();


        SolutionHolder solution = new SolutionHolder();
       // return solution.exampleAnswer(json);
        //return solution.level1Answer(json);
        //return solution.level2Answer(json);
        return solution.level3Answer(json);


    }


}
