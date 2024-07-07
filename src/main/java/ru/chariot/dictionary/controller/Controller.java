package ru.chariot.dictionary.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.chariot.dictionary.model.Dictionary;
import ru.chariot.dictionary.model.Data;
import ru.chariot.dictionary.service.DataService;
import ru.chariot.dictionary.service.DictionaryService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dictionaries")
public class Controller {

    DictionaryService dictionaryService;
    DataService dataService;

    @GetMapping("/{dictionaryId}")
    @Tag(name = "Получение записи", description = "Получение записи из таблицы dictionary основываясь на ее уникальном идентификаторе, тело запроса не запрашивается")
    public Dictionary getDictionary(
            @PathVariable("dictionaryId")
            @Parameter(name ="dictionaryId", description = "id справочника", example = "1") Long dictionaryId){

        return dictionaryService.findDictionaryById(dictionaryId);

    }

    @GetMapping
    @Tag(name = "Получение всех записей", description = "Получение всех записей из таблицы dictionary, тело запроса не запрашивается")
    public List<Dictionary> getAllDictionary(){

        return dictionaryService.findAllDictionary();

    }

    @PostMapping
    @Tag(name = "Добавление записи", description = "Добавление записи в таблицу dictionary, в тело запроса передать такие параметры как code(строка), description(строка), указывать идентификатор не требуется")
    public Dictionary addRecord(@RequestBody Dictionary dictionary){

        return dictionaryService.saveDictionary(dictionary);

    }


    @PutMapping("/{dictionaryId}")
    @Tag(name = "Изменение записи", description = "Изменение записи в таблице dictionary, в тело запроса передать такие параметры как code(строка), description(строка)")
    public Dictionary putDictionary(
            @PathVariable("dictionaryId")
            @Parameter(name ="dictionaryId", description = "id записи в справочнике", example = "1") Long dictionaryId, @RequestBody Dictionary dictionary){

        return dictionaryService.updateDictionary(dictionaryId, dictionary);

    }

    @DeleteMapping("/del/{dictionaryId}")
    @Tag(name = "Удаление записи", description = "Удаление записи из таблицы dictionary, айди записи указать в конце url, пример: dictionaries/1")
    public Dictionary delDictionary(
            @PathVariable("dictionaryId")
            @Parameter(name ="dictionaryId", description = "id справочника", example = "1") Long dictionaryId){

        return dictionaryService.deleteDictionary(dictionaryId);

    }

    @GetMapping("/records/{recordId}")
    @Tag(name = "Получение записи", description = "Получение записи из таблицы data основываясь на ее уникальном идентификаторе, тело запроса не запрашивается, айди искомой записи указать в конце url, пример: dictionaries/records/1")
    public Data getDictRec(
            @PathVariable("recordId")
            @Parameter(name ="recordId", description = "id справочника", example = "1") Long recordId){
        return dataService.findDataById(recordId);
    }

    @GetMapping("/records")
    @Tag(name = "Получение всех записей", description = "Получение всех записей из таблицы data, тело запроса не запрашивается")
    public List<Data> getAllDictRecords(){
        return dataService.findAllData();
    }

    @PostMapping("/records")
    @Tag(name = "Добавление записи", description = "Добавление записи в таблицу data, в тело запроса передать такие параметры как dictionary_id(положительное целое число), code(строка), value(строка), указывать идентификатор не требуется")
    public Data addRecord(@RequestBody Data data){

        return dataService.saveData(data);

    }

    @PutMapping("/records/{recordId}")
    @Tag(name = "Изменение записи", description = "Изменение записи в таблице data, в тело запроса передать такие параметры как dictionary_id(положительное целое число), code(строка), value(строка), айди изменяемой записи указать в конце url, пример: dictionaries/records/1")
    public Data updateRecord(
            @PathVariable("recordId")
            @Parameter(name ="recordId", description = "id записи в справочнике", example = "1") Long recordId, @RequestBody Data data){

        return dataService.updateData(recordId, data);

    }

    @DeleteMapping("/records/del/{recordId}")
    @Tag(name = "Удаление записи", description = "Удаление записи из таблицы dictionary, айди записи указать в конце url, пример: dictionaries/records/1")
    public Data delRecord(
            @PathVariable("recordId")
            @Parameter(name ="recordId", description = "id записи в справочнике", example = "1") Long recordId){

        return dataService.deleteData(recordId);

    }

}
