package th.bt.btportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.bt.btportal.entities.ResourceDataEntity;
import th.bt.btportal.models.Response;
import th.bt.btportal.services.ResourceService;
import th.bt.btportal.utils.DateTimeUtil;
import th.bt.btportal.utils.GenerateUtil;

import java.util.*;

@RestController
@CrossOrigin(value = "*")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @ResponseBody
    @GetMapping(value="/resourceAll")
    public List<ResourceDataEntity> Test(){
        List<ResourceDataEntity> resourcelist = new ArrayList<ResourceDataEntity>();
        resourcelist = resourceService.getAllResource();
        Collections.reverse(resourcelist); //reverse List
        return resourcelist;
    }

    @ResponseBody
    @GetMapping(value="/activeResource")
    public ResourceDataEntity getResourceByStatus(){
        List<ResourceDataEntity> resourcelist = new ArrayList<ResourceDataEntity>();
        resourcelist = resourceService.findByStatus("active");
        //reverse List
        return resourcelist.get(0);
    }

    @ResponseBody
    @GetMapping(value="/resource/{id}")
    public ResourceDataEntity getFromID(@PathVariable String id ){
        System.out.println(id);
        Optional<ResourceDataEntity> resource = Optional.of(new ResourceDataEntity());
        resource = resourceService.getByID(id);
        return resource.orElse(null);

    }


    @ResponseBody
    @PostMapping(value="/resource")
    public ResponseEntity<Object> insertResource(@RequestBody ResourceDataEntity resource){
        Response resp = new Response();

        try {
            resource.setId(GenerateUtil.genUUIDAll());
            Date datetime =new Date();
            datetime=DateTimeUtil.dateTime();
            resource.setCreateDateTime(datetime);
            resource.setUpdateDateTime(datetime);
            resource.setStatus("inactive");
            resourceService.createResource(resource);
            resp.setRespCode("0000");
            resp.setRespDesc("Success");
        }
        catch (Exception e){
            resp.setRespCode("9999");
            resp.setRespDesc("Error");
        }

        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping(value="/resource/{id}")
    public ResponseEntity<Object> updateResource(@RequestBody ResourceDataEntity resource,@PathVariable String id){
        Response resp = new Response();
        Date datetime =new Date();
        datetime=DateTimeUtil.dateTime();
        try {
            Optional<ResourceDataEntity> getResource = Optional.of(new ResourceDataEntity());
            getResource = resourceService.getByID(id);
            if(getResource.isEmpty()) {
                resp.setRespCode("9001");
                resp.setRespDesc("Error Data Not found");
                return new ResponseEntity<Object>(resp, HttpStatus.UNPROCESSABLE_ENTITY);
            }

            if (resource.getStatus().equals("active")) {
                if(getResource.get().getStatus().equals("active")){
                    resource.setActivateDateTime(datetime);
                }
            }
            resource.setId(id);
            resource.setUpdateDateTime(datetime);
            resourceService.updateResource(resource);
            resp.setRespCode("0000");
            resp.setRespDesc("Update Success");
        }
        catch (NoSuchElementException e){
            resp.setRespCode("9001");
            resp.setRespDesc("Error Data Not found");
        }
        catch (Exception e){
            System.out.println(e.toString());
            resp.setRespCode("9999");
            resp.setRespDesc("Error");
        }

        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }
}
