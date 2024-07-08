package ru.chariot.dictionary.service;

import ru.chariot.dictionary.model.Data;

import java.util.List;

public interface DataService {

    Data saveData(Data data);
    Data findDataById(Long id);
    List<Data> findAllData();
    Data updateData(Long id, Data data);
    Data deleteData(Long id);

}