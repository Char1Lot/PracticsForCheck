package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Data;
import ru.chariot.dictionary.reposetory.DataRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    DataRepository dataRepository;
    final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

    @Override
    public Data saveData(Data data) {

        logger.info(

                "Method : saveData was called with arguments : " +

                        "\n\t id : ${data.getId()} " +
                        "\n\t dictionaryId : ${data.getDictionaryId()} " +
                        "\n\t code : ${data.getCode()} " +
                        "\n\t value : ${data.getValue()} "

        );

        if(data != null && !data.isBreak()) {

            Data savedData = dataRepository.save(data);

            logger.info(

                    "Method was successfully called and return Data :" +

                            "\n\n\t\t id : ${savedData.getId()}" +
                            "\n\t\t dictionaryId : ${savedData.getDictionaryId()}" +
                            "\n\t\t code : ${savedData.getCode()}" +
                            "\n\t\t value : ${savedData.getValue()}"

            );



            return savedData;

        }

        logger.info("Method : saveData was called but an argument was null");

        return null;

    }

    @Override
    public Data findDataById(Long id) {

        if(id > 0) {

            Data foundedData = dataRepository.findById(id).get();

            logger.info(

                    "Method : findDataById was called with argument: " +

                            "\n id : ${id} " +
                            "return Data : " +
                            "\n\t id : ${foundedData.getId()}" +
                            "\n\t dictionaryId : ${foundedData.getDictionaryId()}" +
                            "\n\t code : ${foundedData.getCode()}" +
                            "\n\t value : ${foundedData.getValue()}"

            );

            return foundedData;

        }

        logger.info("Method findDataById was called but an argument was less than 0 (id < 0)");

        return null;

    }

    @Override
    public List<Data> findAllData(){

        logger.info(

                "Method : findAllData was called and return list of Data : " +

                        "\n {dataRepository.findAll()}"

        );

        return dataRepository.findAll();

    }

    @Override
    public Data updateData(Long id, Data data) {

        Data inputData = dataRepository.findById(id).get();

        if(id < 1 || data.isBreak()){
            logger.info(

                    "Method updateData was called but an argument was null"

            );

            return null;
        }

        logger.info(

                "Method : updateData was called, old value of Data : " +

                        "\n\t id : ${inputData.getId()}" +
                        "\n\t dictionaryId : ${inputData.getDictionaryId()}" +
                        "\n\t code : ${inputData.getCode()}" +
                        "\n\t value : ${inputData.getValue()}"

        );

        inputData.setDictionaryId(data.getDictionaryId());
        inputData.setCode(data.getCode());
        inputData.setValue(data.getValue());

        logger.info(

                "New value of Data :" +

                        "\n\t id : ${inputData.getId()}" +
                        "\n\t dictionaryId : ${inputData.getDictionaryId()}" +
                        "\n\t code : ${inputData.getCode()}" +
                        "\n\t value : ${inputData.getValue()}"

        );

        Data savedData = dataRepository.save(inputData);

        return savedData;

    }

    @Override
    public Data deleteData(Long id) {

        if(id > 0) {

            Data deletedData = dataRepository.findById(id).get();

            logger.info(

                    "Method : deleteData was called with argument : " +

                            "\n\t id : ${id}" +

                            "return deleted object : " +

                            "\n\t id : ${deletedData.getId()}" +
                            "\n\t dictionaryId : ${deletedData.getDictionaryId}" +
                            "\n\t code : ${deletedData.getCode()}" +
                            "\n\t value : ${deletedData.getValue()}"

            );

            dataRepository.delete(dataRepository.findById(id).get());

            return deletedData;

        }

        logger.info("Method deleteData was called but an argument less than 0 (id < 0)");

        return null;

    }
}