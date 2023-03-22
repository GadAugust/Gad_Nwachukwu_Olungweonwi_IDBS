/*
 * Copyright (C) 1993-2020 ID Business Solutions Limited
 * All rights reserved
 */
package com.idbs.devassessment.solution;

import com.idbs.devassessment.core.IDBSSolutionException;
import com.idbs.devassessment.core.DifficultyLevel;


import com.idbs.devassessment.harness.DigitalTaxTracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Polynomial {

    public long evaluatePower (int base, int power)
    {   int step = power;
        long answer = base;
        long increment = base;

        if (power == 0)
            return 1;

        for (int i = 1; i < step; i++) {
            for (int j = 1; j < base; j++) {
                answer = DigitalTaxTracker.add(answer, increment);
            }
            increment = answer;
        }
        return answer;
    }

    public long evaluateMultiplier(int multiplier, long powerValue)
    {
        long ans = 0;
        for (int i = 1; i <= multiplier; i++) {
            ans = DigitalTaxTracker.add(ans, powerValue);
        }
        return ans;
    }

    public int getXValue(String json){
        String[] firstArray = json.split(";");
        String firstPart = firstArray[0];
        String[] secondArray = firstPart.split("=");
        return Integer.valueOf(secondArray[1].trim());
    }

    public String getEquation(String json){
        String[] firstArray = json.split("=");
        return firstArray[2];
    }

    public String[] getEquationParts(String equation){
        String[]tokens = equation.split("-|\\+");
        tokens = removeArrayElement(tokens, 0);
        for(String t : tokens){
            System.out.println(t);
        }
        System.out.println(tokens.length);

        int minusNum = countChar(equation, '-');
        int plusNum = countChar(equation, '+');
        System.out.println(minusNum + " - " + plusNum);
        String[]operatorHolder = new String[5];
        String[]operators = equation.split("");
        int j = 0;
        for(int i = 0; i < operators.length; i++){
            if(operators[i].equals("-") || operators[i].equals("+")){
                tokens[j] = operators[i] + tokens[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(tokens));
        return tokens;
    }

    public int getPower(String part){
        System.out.println("Part sent " + part);
        String[] splitString = part.split("\\^");
        System.out.println("Splitted String " + Arrays.toString(splitString));
        if(splitString[0].equals(part)){
            System.out.println("Inner Power " + 1);
            return 1;
        }
        System.out.println("Outer Power " + Integer.valueOf(splitString[1]));
        return Integer.valueOf(splitString[1]);
    }

    public int getMultiplier(String part){
        String[] splitString = part.split("\\.");
        if(splitString.length == 0){
            return 1;
        }
        return Integer.parseInt(splitString[0].substring(1));
    }

    public String getAction(String part){
        String[] splitString = part.split(".");
        String action = "";
        if(splitString.length == 0){
            action = String.valueOf(part.charAt(0));
        }else {
            action = String.valueOf(splitString[0].charAt(0));
        }
        if(action.equals("+")){
            return "add";
        }else{
            return "subtract";
        }
    }

    public String[] removeArrayElement(String[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create ArrayList from the array
        List<String> arrayList = new ArrayList<>(Arrays.asList(arr));

        // Remove the specified element
        arrayList.remove(index);

        // return the resultant array
        String[] arry = new String[arrayList.size()];
        arry = arrayList.toArray(arry);
        return arry;
    }

    public int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }

}