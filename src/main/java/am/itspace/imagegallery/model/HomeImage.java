package am.itspace.imagegallery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "home")
public class HomeImage {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String picUrl;
}
