package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.UserWeather;

public interface UserRepository extends CrudRepository<UserWeather, Long> {
    UserWeather findByEmail(String email);
}