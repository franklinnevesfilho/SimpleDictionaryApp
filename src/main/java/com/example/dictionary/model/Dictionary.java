package com.example.dictionary.model;

import javafx.scene.Parent;

public class Dictionary {
    public WordList currentWords = new WordList();
    public WordList deletedWords = new WordList();

    public Dictionary() {}

    public void add(Word word) {
        if(WordList.isRepeatedWord(currentWords, word)){
            if(!currentWords.nodeAt(word).getVal().containsDefinition(word.getDefinition())){
                currentWords.nodeAt(word).getVal().addDefinition(word.getDefinition());
            }
        }else{
            currentWords.add(word);
        }

        currentWords.sort();
    }


    public boolean deleteWord(String word){
        boolean result = false;
        for(int i = 0; i < currentWords.size(); i++){
            if(currentWords.nodeAt(i).getVal().getWord().equalsIgnoreCase(word)){
                currentWords.remove(currentWords.nodeAt(i).getVal());
                break;
            }
        }
        return result;
    }

    public WordList getCurrentWords() {
        return currentWords;
    }
    public WordList getDeletedWords() {
        return deletedWords;
    }

}
