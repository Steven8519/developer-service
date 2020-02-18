package info.devlink.developerservice.repository;

import info.devlink.developerservice.model.Developer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DeveloperRepository extends ReactiveMongoRepository<Developer, String > {
}
