package th.bt.btportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import th.bt.btportal.entities.ResourceDataEntity;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface ResourceRepository extends MongoRepository<ResourceDataEntity, String> {
    List<ResourceDataEntity> findByStatus(String status);
}
