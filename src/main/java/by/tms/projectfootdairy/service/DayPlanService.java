package by.tms.projectfootdairy.service;

import by.tms.projectfootdairy.entity.DayPlan;
import by.tms.projectfootdairy.exception.NotFoundException;
import by.tms.projectfootdairy.repository.DayPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DayPlanService {

    @Autowired
    private DayPlanRepository dayPlanRepository;

    public DayPlanService(DayPlanRepository dayPlanRepository) {
        this.dayPlanRepository = dayPlanRepository;
    }

    public DayPlan save(DayPlan dayPlan) {
        return dayPlanRepository.save(dayPlan);
    }

    public void delete(DayPlan dayPlan) {
        dayPlanRepository.delete(dayPlan);
    }

    public  void delete(Long id) {
        dayPlanRepository.deleteById(id);
    }

    public DayPlan findById(Long id) {
        return dayPlanRepository.findById(id).orElseThrow(() -> new NotFoundException("No DayPlan found with id: " + id));
    }

}
