package org.example.quoraspringboot.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private String content;
    private Long questionId;
    private Long userId;
}
