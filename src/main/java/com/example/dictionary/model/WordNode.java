package com.example.dictionary.model;

public class WordNode {
    private Word value;
    private WordNode nextVal;


    // Initializes the object
    public WordNode(Word word){
        this.value = word;
        this.nextVal = null;
    }


    // Sets the nextVal property
    public void setNext(WordNode nextVal) {
        this.nextVal = nextVal;
    }

    public void setVal(Word word){
        this.value = word;
    }
    public Word getVal(){
        return this.value;
    }
    public WordNode getNext(){
        return nextVal;
    }
}
