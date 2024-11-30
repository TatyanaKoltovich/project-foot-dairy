package by.tms.projectfootdairy.service;

import by.tms.projectfootdairy.entity.DayFact;
import by.tms.projectfootdairy.exception.NotFoundException;
import by.tms.projectfootdairy.repository.DayFactRepository;

public class DayFactService {

    private final DayFactRepository dayFactRepository;

    public DayFactService(DayFactRepository dayFactRepository) {
        this.dayFactRepository = dayFactRepository;
    }

    public DayFact save(DayFact dayFact) {
        return dayFactRepository.save(dayFact);
    }

    public void delete(DayFact dayFact) {
        dayFactRepository.delete(dayFact);
    }

    public void delete(Long id) {
        dayFactRepository.deleteById(id);
    }

    public void findById(Long id) {
        DayFact dayFact = dayFactRepository.findById(id).orElseThrow(() -> new NotFoundException("Day fact not found"));

    }
}
