package com.example.dictionary.model;

import javafx.scene.Parent;

public class WordList  {
    private WordNode head;
    private int size = 0;

    public WordList(){}

    public void add(Word word){
        WordNode newNode = new WordNode(word);

        if(head == null){
            head = newNode;
        }else{
            WordNode temp = head;

            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }

        size++;
    }

    public boolean remove(Word word){
        boolean success = false;
        if(head != null){
            WordNode current = head;
            // while success is false and the next value is not null
            while(!success && current.getNext() != null){
                // If next node value equals word
                if(current.getNext().getVal().equals(word)){
                    // current.getNext is the node we want to delete
                    // so get the following node and change current.getNext
                    WordNode next = current.getNext().getNext();
                    current.setNext(next);
                    success = true;
                }else{
                    current = current.getNext();
                }
            }
        }

        if(success){
            size--;
        }

        return success;
    }

    public int size(){
        return size;
    }


    public WordNode nodeAt(int index){
        if(index < size) {
            WordNode node = head;
            for (int i = 0; i < index; i++) {
             node = node.getNext();
            }
            return node;
        }else{
            return null;
        }
    }

    public WordNode nodeAt(Word word){
        WordNode node = null;
        for (int i = 0; i < size; i++){
            if(nodeAt(i).getVal().getWord().equals(word.getWord())){
                node = nodeAt(i);
                break;
            }
        }

        return node;
    }

    public static boolean isRepeatedWord(WordList list,Word word) {
        boolean result = false;
        for(int i = 0; i < list.size(); i++) {
            if(list.nodeAt(i).getVal().getWord().equals(word.getWord())){
                result = true;
                break;
            }
        }
        return result;
    }

    public void sort(){
        Word temp;
        // The following algorithm is called a bubble sort.
        // It iterates through the list twice, comparing each object with the ones that come after it.
        // if an object comes before it, they will then switch places.
        for(int i = 0; nodeAt(i).getNext() != null; i++){
            for(int j = i+1; nodeAt(j).getNext() != null; j++){
                if(nodeAt(i).getVal().getWord().toUpperCase().charAt(0) > nodeAt(j).getVal().getWord().toUpperCase().charAt(0)){

                    temp = nodeAt(i).getVal();

                    nodeAt(i).setVal(nodeAt(j).getVal());
                    nodeAt(j).setVal(temp);
                }
            }
        }

    }

    public String toString(){
        StringBuilder completeList = new StringBuilder();
        WordNode current;

        if(head != null){
            current = head;
            while(current.getNext() != null){
                completeList.append(current.getVal().getWord()).append("\n");
                current = current.getNext();
            }
            completeList.append(current.getVal().getWord());
        }

        return completeList.toString();
    }

}