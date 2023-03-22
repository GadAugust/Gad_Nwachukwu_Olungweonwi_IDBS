package com.idbs.devassessment.solution;

import com.idbs.devassessment.core.DifficultyLevel;
import com.idbs.devassessment.core.IDBSSolutionException;
import com.idbs.devassessment.harness.DigitalTaxTracker;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class SolutionHolder  {
    public String exampleAnswer(String json) {

        /*
         * This is the default solution and provides some example code on how to extract data from Json in java.
         *
         * As an initial start we suggest you comment ALL the code below and return a null value from the method. Run
         * this in the assessment application and you'll see many examples of the Json that question produces.
         */

        // first get Json as a String for the question using the inherited method...


        // now use the json api to read the json to give a JsonObject representing the Json...
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        // now start extracting the data you need from the json....

        // get the start value from the Json
        int startValue = jsonObject.getInt("startValue");

        // read the values array from the json
        JsonArray jsonArray = jsonObject.getJsonArray("values");

        // now sum the array
        int arraySum = 0;

        for (int i = 0; i < jsonArray.size(); i++)
        {
            arraySum += jsonArray.getInt(i);
        }

        // calculate the answer..
        int answer = startValue - arraySum;

        return Integer.toString(answer);

    }





    public String level1Answer( String json ) {
        // first get Json as a String for the question using the inherited method...


        // now use the json api to read the json to give a JsonObject representing the Json...
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        // now start extracting the data you need from the json....

        // get the start value from the Json
        int xValue = jsonObject.getInt("xValue");
        int power;
        int multiplier;
        String action;
        long powerValue;
        long multiplierValue;
        long finalAnswer = 0;
        JsonObject obj;

        // read the values array from the json
        JsonArray jsonArray = jsonObject.getJsonArray("terms");


        for (int i = 0; i < jsonArray.size(); i++) {
            Polynomial polynomial = new Polynomial();
            obj = jsonArray.getJsonObject(i);
            power = obj.getInt("power");
            multiplier = obj.getInt("multiplier");
            action = obj.getString("action");
            powerValue = polynomial.evaluatePower(xValue, power);
            multiplierValue = polynomial.evaluateMultiplier(multiplier, powerValue);
            if (String.valueOf(action).equals(String.valueOf("add"))) {
                finalAnswer += multiplierValue;
            } else {
                finalAnswer -= multiplierValue;
            }
        }
        return String.valueOf(finalAnswer);

    }
    public String level2Answer( String json ) {


        if(json.contains("numeric")){
            Polynomial poly = new Polynomial();
            int xValue = poly.getXValue(json);
            System.out.println("xValue" + xValue);
            String equation = poly.getEquation(json);
            String[] equationParts = poly.getEquationParts(equation);
            String obj = "";
            int power;
            int multiplier;
            String action;
            long powerValue;
            long multiplierValue;
            long finalAnswer = 0;
            String actionHolder = "";

            for (int i = 0; i < equationParts.length; i++) {
                obj = equationParts[i];
                power = poly.getPower(obj);
                multiplier = poly.getMultiplier(obj);
                action = poly.getAction(obj);
                powerValue = poly.evaluatePower(xValue, power);
                multiplierValue = poly.evaluateMultiplier(multiplier, powerValue);
//                System.out.println(power + " - " + powerValue);
//                System.out.println(multiplier + " * " + powerValue + " = " + multiplierValue + " (" + action + ")");
                if (String.valueOf(action).equals(String.valueOf("add"))) {
                    actionHolder += "add";
                    finalAnswer += multiplierValue;
                } else {
                    actionHolder += "subtract";
                    finalAnswer -= multiplierValue;
                }
            }
            return String.valueOf(finalAnswer);

        }else{
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = reader.readObject();
            reader.close();

            int xValue = jsonObject.getInt("xValue");
            JsonArray terms = jsonObject.getJsonArray("terms");

            int power;
            int multiplier;
            String action;
            long powerValue;
            long multiplierValue;
            long finalAnswer = 0;
            String actionHolder = "";
            JsonObject obj;

            for (int i = 0; i < terms.size(); i++) {
                Polynomial polynomial = new Polynomial();
                obj = terms.getJsonObject(i);
                power = obj.getInt("power");
                multiplier = obj.getInt("multiplier");
                action = obj.getString("action");
                powerValue = polynomial.evaluatePower(xValue, power);
                multiplierValue = polynomial.evaluateMultiplier(multiplier, powerValue);
//                System.out.println(power + " - " + powerValue);
//                System.out.println(multiplier + " * " + powerValue + " = " + multiplierValue + " (" + action + ")");
                if (String.valueOf(action).equals(String.valueOf("add"))) {
                    actionHolder += "add";
                    finalAnswer += multiplierValue;
                } else {
                    actionHolder += "subtract";
                    finalAnswer -= multiplierValue;
                }
            }
            return String.valueOf(finalAnswer);
        }
    }
    public String level3Answer( String json ) {


        if(json.contains("numeric")){
            Polynomial poly = new Polynomial();
            int xValue = poly.getXValue(json);
            System.out.println("xValue" + xValue);
            String equation = poly.getEquation(json);
            String[] equationParts = poly.getEquationParts(equation);
            String obj = "";
            int power;
            int multiplier;
            String action;
            long powerValue;
            long multiplierValue;
            long finalAnswer = 0;
            String actionHolder = "";

            for (int i = 0; i < equationParts.length; i++) {
                obj = equationParts[i];
                power = poly.getPower(obj);
                multiplier = poly.getMultiplier(obj);
                action = poly.getAction(obj);
                powerValue = poly.evaluatePower(xValue, power);
                multiplierValue = poly.evaluateMultiplier(multiplier, powerValue);
//                System.out.println(power + " - " + powerValue);
//                System.out.println(multiplier + " * " + powerValue + " = " + multiplierValue + " (" + action + ")");
                if (String.valueOf(action).equals(String.valueOf("add"))) {
                    actionHolder += "add";
                    finalAnswer = DigitalTaxTracker.add(finalAnswer, multiplierValue);
                } else {
                    actionHolder += "subtract";
                    finalAnswer = DigitalTaxTracker.subtract(finalAnswer, multiplierValue);
                }
            }
            return String.valueOf(finalAnswer);

        }else{
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = reader.readObject();
            reader.close();

            int xValue = jsonObject.getInt("xValue");
            JsonArray terms = jsonObject.getJsonArray("terms");

            int power;
            int multiplier;
            String action;
            long powerValue;
            long multiplierValue;
            long finalAnswer = 0;
            String actionHolder = "";
            JsonObject obj;

            for (int i = 0; i < terms.size(); i++) {
                Polynomial polynomial = new Polynomial();
                obj = terms.getJsonObject(i);
                power = obj.getInt("power");
                multiplier = obj.getInt("multiplier");
                action = obj.getString("action");
                powerValue = polynomial.evaluatePower(xValue, power);
                multiplierValue = polynomial.evaluateMultiplier(multiplier, powerValue);
//                System.out.println(power + " - " + powerValue);
//                System.out.println(multiplier + " * " + powerValue + " = " + multiplierValue + " (" + action + ")");
                if (String.valueOf(action).equals(String.valueOf("add"))) {
                    actionHolder += "add";
                    finalAnswer = DigitalTaxTracker.add(finalAnswer, multiplierValue);
                } else {
                    actionHolder += "subtract";
                    finalAnswer = DigitalTaxTracker.subtract(finalAnswer, multiplierValue);
                }
            }
            return String.valueOf(finalAnswer);
        }
    }
}
