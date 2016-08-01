package pl.mariuszpawlowski.psychoffice.service.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mariuszpawlowski.psychoffice.domain.jpa.Visit;
import pl.mariuszpawlowski.psychoffice.repository.VisitRepository;

import java.util.Optional;

/**
 * Created by Mariusz.Pawlowski on 2016-08-01.
 */
@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Optional<Visit> getUserById(long id) {
        return Optional.ofNullable(visitRepository.findOne(id));
    }

    @Override
    public Iterable<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}
