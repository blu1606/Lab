/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LetterAndCharacterCount;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class Words {
    private String str;

    public Words(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Map<String, Integer> countWordFrequency() {
        Map<String, Integer> wordFrequency = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f,.:;!?(){}");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    public Map<Character, Integer> countCharacterFrequency() {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
            }
        }
        return characterFrequency;
    }
}
