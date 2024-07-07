package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Dictionary;
import ru.chariot.dictionary.reposetory.DictionaryReposetory;


import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImp implements DictionaryService{

    DictionaryReposetory dictionaryReposetory;

    @Override
    public Dictionary saveDictionary(Dictionary dictionary) {
        return dictionaryReposetory.save(dictionary);
    }

    @Override
    public Dictionary findDictionaryById(Long id) {

        return dictionaryReposetory.findById(id).get();

    }

    @Override
    public Dictionary updateDictionary(Long id, Dictionary dictionary) {
        Dictionary updateDictionary = dictionaryReposetory.findById(id).get();;

        updateDictionary.setCode(dictionary.getCode());
        updateDictionary.setDescription(dictionary.getDescription());

        dictionaryReposetory.save(updateDictionary);

        return updateDictionary;
    }

    @Override
    public Dictionary deleteDictionary(Long id){

        Dictionary deletedDictionary = dictionaryReposetory.findById(id).get();

        dictionaryReposetory.delete(dictionaryReposetory.findById(id).get());

        return deletedDictionary;

    }

    @Override
    public List<Dictionary> findAllDictionary(){

        return dictionaryReposetory.findAll();

    }

}
