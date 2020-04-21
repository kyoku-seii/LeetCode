package com.leetcode.question299;

import java.util.HashMap;

public class Solution {
    public String getHint(String secret, String guess) {
        int bullsNumber = 0;
        int cowsNumber = 0;
        int length = secret.length();
        HashMap<Character,Integer> secretMap = new HashMap<>();
        HashMap<Character,Integer> guessMap = new HashMap<>();

        for(int i=0;i<length;i++){
            if(guess.charAt(i)==secret.charAt(i)){
                bullsNumber++;
            }else {
                char secretWord = secret.charAt(i);
                if(!secretMap.containsKey(secretWord))
                    secretMap.put(secretWord,1);
                else secretMap.put(secretWord,secretMap.get(secretWord)+1);

                char guessWord = guess.charAt(i);
                if(!guessMap.containsKey(guessWord))
                    guessMap.put(guessWord,1);
                else guessMap.put(guessWord,guessMap.get(guessWord)+1);
            }
        }

        for(char c : secretMap.keySet()){
            if(guessMap.containsKey(c)){
                cowsNumber = cowsNumber + Math.min(guessMap.get(c),secretMap.get(c));
            }
        }

        return bullsNumber+"A"+cowsNumber+"B";
    }
}
