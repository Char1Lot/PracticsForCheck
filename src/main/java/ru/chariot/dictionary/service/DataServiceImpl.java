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

                "\n\t id : {} " +
                "\n\t dictionaryId : {} " +
                "\n\t code : {} " +
                "\n\t value : {} " +
                "\n\n\t return object with arguments : " +
                "\n\n\t\t id : {}" +
                "\n\t\t dictionaryId : {}" +
                "\n\t\t code : {}" +
                "\n\t\t value : {}",

                data.getId(),
                data.getDictionaryId(),
                data.getCode(),
                data.getValue(),
                dataRepository.save(data).getId(),
                dataRepository.save(data).getDictionaryId(),
                dataRepository.save(data).getCode(),
                dataRepository.save(data).getValue()

        );

        return dataRepository.save(data);

    }

    @Override
    public Data findDataById(Long id) {

        logger.info(

                "Method : findDataById was called with id : {} \n\t return object with arguments : " +

                "\n\t\t id : {}" +
                "\n\t\t dictionaryId : {}" +
                "\n\t\t code : {}" +
                "\n\t\t value : {}",

                id,
                dataRepository.findById(id).get().getId(),
                dataRepository.findById(id).get().getDictionaryId(),
                dataRepository.findById(id).get().getCode(),
                dataRepository.findById(id).get().getValue()

        );

        return dataRepository.findById(id).get();

    }

    @Override
    public List<Data> findAllData(){

        logger.info(

                "Method : findAllData was called and return : {}",

                dataRepository.findAll()

        );

        return dataRepository.findAll();

    }

    @Override
    public Data updateData(Long id, Data data) {
        Data inputData = dataRepository.findById(id).get();

        logger.info(

                "Method : updateData was called, old value : " +

                "\n\t id : {}" +
                "\n\t dictionaryId : {}" +
                "\n\t code : {}" +
                "\n\t value : {}" +
                "New value :" +
                "\n\t id : {}" +
                "\n\t dictionaryId : {}" +
                "\n\t code : {}" +
                "\n\t value : {}",

                dataRepository.findById(id).get().getId(),
                dataRepository.findById(id).get().getDictionaryId(),
                dataRepository.findById(id).get().getCode(),
                dataRepository.findById(id).get().getValue(),
                data.getId(),
                data.getDictionaryId(),
                data.getClass(),
                data.getValue()

        );

        inputData.setDictionaryId(data.getDictionaryId());
        inputData.setCode(data.getCode());
        inputData.setValue(data.getValue());

        return dataRepository.save(inputData);

    }

    @Override
    public Data deleteData(Long id) {

        logger.info(

                "Method : deleteData was called with argument : " +
                "\n\t id : {}",

                id

        );

        Data deletedData = dataRepository.findById(id).get();

        dataRepository.delete(dataRepository.findById(id).get());

        return deletedData;

    }
}