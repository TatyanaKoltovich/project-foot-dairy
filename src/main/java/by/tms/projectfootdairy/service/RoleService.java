package by.tms.projectfootdairy.service;

import by.tms.projectfootdairy.entity.Role_;
import by.tms.projectfootdairy.exception.NotFoundException;
import by.tms.projectfootdairy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role_ save(Role_ role) {
        return roleRepository.save(role);
    }

    public void delete(Role_ role) {
        roleRepository.delete(role);
    }

    public void delete(Role_ role, Long id) {
       roleRepository.deleteById(id);
    }

    public Role_ findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));
    }


}
