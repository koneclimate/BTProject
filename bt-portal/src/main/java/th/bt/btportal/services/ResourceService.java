package th.bt.btportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.bt.btportal.entities.ResourceDataEntity;
import th.bt.btportal.repository.ResourceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceDataEntity updateResource(ResourceDataEntity resource) {
        return resourceRepository.save(resource);
    }
    public ResourceDataEntity createResource(ResourceDataEntity resource) {
        return resourceRepository.insert(resource);
    }
    public List<ResourceDataEntity> getAllResource(){
        return  resourceRepository.findAll();
    }
    public List<ResourceDataEntity> findByStatus(String status){
        return  resourceRepository.findByStatus(status);
    }
    public Optional<ResourceDataEntity> getByID(String id){
        return  resourceRepository.findById(id);
    }
}
