package am.itspace.imagegallery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDateTime uploadDate;
    private String picUrl;
    @ManyToOne
    private Category category;


}
