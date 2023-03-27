package th.bt.btportal.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "resource")
@Data
public class ResourceDataEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String link;
    private String image;
    private String priority;
    private String timeToFinish;
    private String status;
    private Date createDateTime;
    private Date updateDateTime;
    private Date activateDateTime;
}
