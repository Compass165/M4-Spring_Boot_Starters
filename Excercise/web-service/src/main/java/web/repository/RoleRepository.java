package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.RoleWeather;

public interface RoleRepository extends CrudRepository<RoleWeather, Long> {
    RoleWeather findByName(String name);
}