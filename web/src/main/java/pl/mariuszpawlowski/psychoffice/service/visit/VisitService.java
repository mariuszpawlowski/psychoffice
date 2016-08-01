package pl.mariuszpawlowski.psychoffice.service.visit;

import pl.mariuszpawlowski.psychoffice.domain.jpa.Visit;

import java.util.Optional;

/**
 * Created by Mariusz.Pawlowski on 2016-08-01.
 */
public interface VisitService {

    Optional<Visit> getUserById(long id);

    Iterable<Visit> getAllVisits();

    Visit save(Visit user);

    void delete(Visit user);
}
