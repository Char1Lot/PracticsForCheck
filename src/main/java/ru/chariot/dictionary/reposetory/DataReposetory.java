package ru.chariot.dictionary.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chariot.dictionary.model.Data;

@Repository
public interface DataReposetory extends JpaRepository<Data, Long> {
}
