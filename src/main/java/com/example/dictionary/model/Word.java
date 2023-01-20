package com.example.dictionary.model;

import java.util.StringTokenizer;

public class Word {
    String word;
    StringBuilder definition = new StringBuilder();

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String definition) {
        this.word = word;
        this.definition.append(definition);
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition.toString();
    }


    public void addDefinition(String definition) {
        // checks if the stringbuilder is empty
        if(this.definition.toString().isBlank()){
            this.definition.append(definition);
        }else{
            // adds a new line if it is not
            this.definition.append("\n").append(definition);
        }
    }

    public boolean containsDefinition(String definition){
        boolean result = false;

        // Splits the definitions provided
        String strArr[] = this.definition.toString().split("/n");

        // Checks if the definition has been added
        for(String token : strArr){
            // if definition already exists then return true
            if(token.equals(definition)){
                result = true;
                break;
            }
        }

        return result;
    }

}
