package org.example.quoraspringboot.dtos;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private String title;
    private String content;
    private Long userId;
    private Set<Long> tagIds;
}
