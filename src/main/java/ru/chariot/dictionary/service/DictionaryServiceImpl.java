package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Dictionary;
import ru.chariot.dictionary.reposetory.DictionaryRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService{

    DictionaryRepository dictionaryRepository;
    final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Override
    public Dictionary saveDictionary(Dictionary dictionary) {

        if(dictionary.isBreak()){

            logger.info(

                    "Method : saveData was called but an argument was null"

            );

            return null;

        }

        Dictionary savedDict = dictionary;

        logger.info(

                "Method : saveData was successfully called with arguments : " +
                        "\n\tid : ${dictionary.getId()}" +
                        "\n\tcode : ${dictionary.getCode()}" +
                        "\n\tdescription : ${dictionary.getDescription()}"

        );

        return savedDict;

    }

    @Override
    public Dictionary findDictionaryById(Long id) {

        if(id <= 0){

            logger.info(

                    "Method : findDictionaryById was called but an argument less/or 0(id < 0)"

            );

        }

        Dictionary findDict = dictionaryRepository.findById(id).get();

        logger.info(

                "Method : saveData was successfully called with arguments : " +
                        "\n\tid : ${findDict.getId()}" +
                        "\n\tcode : ${findDict.getCode()}" +
                        "\n\tdescription : ${findDict.getDescription()}"

        );

        return findDict;

    }

    @Override
    public Dictionary updateDictionary(Long id, Dictionary dictionary) {

        if(id < 1 || dictionary.isBreak()){

            logger.info(

                    "Method : updateDictionary was called but an argument was null"

            );

            return null;

        }

        Dictionary inputDictionary = dictionaryRepository.findById(id).get();

        logger.info(

                "Method : updateData was successfully called, old value of Data : " +

                        "\n\t id : ${inputDictionary.getId()}" +
                        "\n\t code : ${inputDictionary.getCode()}" +
                        "\n\t value : ${inputDictionary.getDescription()}"

        );

        inputDictionary.setCode(dictionary.getCode());
        inputDictionary.setDescription(dictionary.getDescription());

        dictionaryRepository.save(inputDictionary);

        logger.info(

                "new value of Data : " +

                        "\n\t id : ${inputDictionary.getId()}" +
                        "\n\t code : ${inputDictionary.getCode()}" +
                        "\n\t value : ${inputDictionary.getDescription()}"

        );

        return inputDictionary;

    }

    @Override
    public Dictionary deleteDictionary(Long id){

        if(id > 0){

            Dictionary deletedDictionary = dictionaryRepository.findById(id).get();

            logger.info(

                    "Method : deleteDictionary was called with an arguments : " +
                            "\n\tid : ${id}" +
                            "return deleted object : " +
                            "\n\tid : ${deletedDictionary.getId()}" +
                            "\n\tcode : ${deletedDictionary.getCode()}" +
                            "\n\tvalue : ${deletedDictionary.getValue()}"

            );

            dictionaryRepository.delete(dictionaryRepository.findById(id).get());

            return deletedDictionary;

        }

        logger.info(

                "Method deleteDictionary was called but an argument was less than 0(id <= 0)"

        );

        return null;

    }

    @Override
    public List<Dictionary> findAllDictionary(){

        List<Dictionary> dictionaryList = dictionaryRepository.findAll();

        logger.info(

                "Method : findAllDictionary was called and returns List of Data:" +
                        "\n\t${dictionaryList}"

        );

        return dictionaryList;

    }

}