package ru.chariot.dictionary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Schema(hidden = true)
    private Long id;

    @Column(name = "dictionary_id", nullable = false)
    @Schema(name = "dictionaryId", example = "1", required = true)
    private Long dictionaryId;

    @Column(name = "code")
    @Schema(name = "code", example = "test", required = false)
    private String code;

    @Column(name = "value", nullable = false)
    @Schema(name = "value", example = "test", required = true)
    private String value;

    public boolean isBreak(){

        return code == "" || id == null || dictionaryId == null || value == "";

    }

}