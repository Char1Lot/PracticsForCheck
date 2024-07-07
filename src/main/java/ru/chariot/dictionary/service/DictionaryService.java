package ru.chariot.dictionary.service;

import ru.chariot.dictionary.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    Dictionary saveDictionary(Dictionary dictionary);
    Dictionary findDictionaryById(Long id);
    Dictionary updateDictionary(Long id, Dictionary dictionary);
    Dictionary deleteDictionary(Long id);
    List<Dictionary> findAllDictionary();

}
