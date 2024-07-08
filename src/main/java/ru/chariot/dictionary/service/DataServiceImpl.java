package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Data;
import ru.chariot.dictionary.reposetory.DataRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    DataRepository dataRepository;

    @Override
    public Data saveData(Data data) {
        return dataRepository.save(data);
    }

    @Override
    public Data findDataById(Long id) {
        return dataRepository.findById(id).get();
    }

    @Override
    public List<Data> findAllData(){
        return dataRepository.findAll();
    }

    @Override
    public Data updateData(Long id, Data data) {
        Data newData = dataRepository.findById(id).get();

        newData.setDictionaryId(data.getDictionaryId());
        newData.setCode(data.getCode());
        newData.setValue(data.getValue());

        return dataRepository.save(newData);
    }

    @Override
    public Data deleteData(Long id) {

        Data deletedData = dataRepository.findById(id).get();

        dataRepository.delete(dataRepository.findById(id).get());

        return deletedData;
    }
}