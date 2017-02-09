package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.repository.Repository;
import pl.mariuszpawlowski.psychoffice.domain.jpa.Visit;

/**
 * Created by Mariusz.Pawlowski on 2016-05-20.
 */
public interface VisitRepository extends Repository<Visit, Long> {
    Iterable<Visit> findAll();

    Visit findById(long id);

    Visit save(Visit visit);

    void delete(Visit visit);
}
