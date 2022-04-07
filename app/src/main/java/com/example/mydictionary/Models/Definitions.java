package com.example.mydictionary.Models;

import java.util.List;

public class Definitions {
    String definition;
    String example;
    List<String> synonyms;
    List<String> antonyms;

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public String getDefinitions() {
        return definition;
    }

    public void setDefinitions(String definitions) {
        this.definition = definitions;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
