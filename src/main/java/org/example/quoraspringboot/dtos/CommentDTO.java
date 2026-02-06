package org.example.quoraspringboot.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String content;
    private Long answerId;
    private Long parentCommentId;
}

