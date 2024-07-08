package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Dictionary;
import ru.chariot.dictionary.reposetory.DictionaryRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService{

    DictionaryRepository dictionaryRepository;

    @Override
    public Dictionary saveDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary findDictionaryById(Long id) { return dictionaryRepository.findById(id).get(); }

    @Override
    public Dictionary updateDictionary(Long id, Dictionary dictionary) {
        Dictionary updateDictionary = dictionaryRepository.findById(id).get();

        updateDictionary.setCode(dictionary.getCode());
        updateDictionary.setDescription(dictionary.getDescription());

        dictionaryRepository.save(updateDictionary);

        return updateDictionary;

    }

    @Override
    public Dictionary deleteDictionary(Long id){

        Dictionary deletedDictionary = dictionaryRepository.findById(id).get();

        dictionaryRepository.delete(dictionaryRepository.findById(id).get());

        return deletedDictionary;

    }

    @Override
    public List<Dictionary> findAllDictionary(){ return dictionaryRepository.findAll(); }

}