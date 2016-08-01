package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mariuszpawlowski.psychoffice.domain.jpa.Visit;

/**
 * Created by Mariusz.Pawlowski on 2016-05-20.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
