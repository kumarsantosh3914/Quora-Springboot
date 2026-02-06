package org.example.quoraspringboot.services;

import org.example.quoraspringboot.dtos.QuestionDTO;
import org.example.quoraspringboot.models.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getQuestions(int page, int size);
    Optional<Question> getQuestionById(Long id);
    Question createQuestion(QuestionDTO questionDTO);
    void deleteQuestion(Long id);
}
