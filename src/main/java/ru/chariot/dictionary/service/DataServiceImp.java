package ru.chariot.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chariot.dictionary.model.Dictionary;
import ru.chariot.dictionary.model.Data;
import ru.chariot.dictionary.reposetory.DataReposetory;

import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImp implements DataService {

    DataReposetory datareposetory;

    @Override
    public Data saveData(Data data) {
        return datareposetory.save(data);
    }

    @Override
    public Data findDataById(Long id) {
        return datareposetory.findById(id).get();
    }

    @Override
    public List<Data> findAllData(){
        return datareposetory.findAll();
    }

    @Override
    public Data updateData(Long id, Data data) {
        Data newData = datareposetory.findById(id).get();

        newData.setDictionary_id(data.getDictionary_id());
        newData.setCode(data.getCode());
        newData.setValue(data.getValue());

        return datareposetory.save(newData);
    }

    @Override
    public Data deleteData(Long id) {

        Data deletedData = datareposetory.findById(id).get();

        datareposetory.delete(datareposetory.findById(id).get());

        return deletedData;
    }
}
