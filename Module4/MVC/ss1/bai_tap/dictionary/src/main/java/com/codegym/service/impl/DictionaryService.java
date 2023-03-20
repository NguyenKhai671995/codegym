package com.codegym.service.impl;

import com.codegym.repository.impl.DictionaryRepo;
import com.codegym.repository.IDicRepos;
import com.codegym.service.IDicSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDicSer {

    IDicRepos dictionaryRepo;

    @Autowired
    public DictionaryService() {
        this.dictionaryRepo = new DictionaryRepo();
    }

    public String getValue(String key) {
        return dictionaryRepo.setDictionary(key);
    }
}
