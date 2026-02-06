package org.example.quoraspringboot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseModel {
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_followed_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> followedTags;
}
