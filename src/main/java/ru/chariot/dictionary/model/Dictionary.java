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
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    @Schema(name = "id", hidden = true)
    private Long id;

    @Column(name = "code", nullable = false)
    @Schema(name = "code", example = "test", required = true)
    private String code;

    @Column(name = "description", nullable = true)
    @Schema(name = "description", example = "test", required = true)
    private String description;

    public boolean isBreak(){
        return id == null || code == "" || description == "";
    }

}