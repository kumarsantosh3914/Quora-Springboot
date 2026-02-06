package org.example.quoraspringboot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.quoraspringboot.dtos.AnswerDTO;
import org.example.quoraspringboot.models.Answer;
import org.example.quoraspringboot.models.Question;
import org.example.quoraspringboot.models.User;
import org.example.quoraspringboot.repositories.AnswerRepository;
import org.example.quoraspringboot.repositories.QuestionRepository;
import org.example.quoraspringboot.repositories.UserRepository;
import org.example.quoraspringboot.services.AnswerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public List<Answer> getAnswersByQuestionId(Long questionId, int page, int size) {
        return answerRepository.findByQuestionId(questionId, PageRequest.of(page, size)).getContent();
    }

    @Override
    public Optional<Answer> getAnswerById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer createAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setContent(answerDTO.getContent());

        Optional<Question> question = questionRepository.findById(answerDTO.getQuestionId());
        question.ifPresent(answer::setQuestion);

        Optional<User> user = userRepository.findById(answerDTO.getUserId());
        user.ifPresent(answer::setUser);

        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}
