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
public class Tag extends BaseModel{
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Question> questions;

    @ManyToMany(mappedBy = "followedTags")
    private Set<User> followers;
}
