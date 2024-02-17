package com.example.Instragram.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postId;
    private String caption ;

    private PostType postType;

    private LocalDateTime postCreatedTimeStamp;
    private LocalDateTime postUpdateTimeStamp;
    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id")
    private User postOwner;

}
