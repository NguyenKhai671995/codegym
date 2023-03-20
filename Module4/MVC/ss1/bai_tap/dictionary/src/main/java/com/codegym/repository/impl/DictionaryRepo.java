package com.codegym.repository.impl;

import com.codegym.repository.IDicRepos;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepo implements IDicRepos {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("cat", "meo");
        dictionary.put("dog", "cho");
        dictionary.put("age", "tuoi");
    }


    public String setDictionary(String key) {
        return dictionary.get(key);
    }
}
