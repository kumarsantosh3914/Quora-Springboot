package org.example.quoraspringboot.services;

import org.example.quoraspringboot.dtos.AnswerDTO;
import org.example.quoraspringboot.models.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> getAnswersByQuestionId(Long questionId, int page, int size);
    Optional<Answer> getAnswerById(Long id);
    Answer createAnswer(AnswerDTO answerDTO);
    void deleteAnswer(Long id);
}
