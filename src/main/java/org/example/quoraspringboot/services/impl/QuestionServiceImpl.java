package org.example.quoraspringboot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.quoraspringboot.dtos.QuestionDTO;
import org.example.quoraspringboot.models.Question;
import org.example.quoraspringboot.models.Tag;
import org.example.quoraspringboot.models.User;
import org.example.quoraspringboot.repositories.QuestionRepository;
import org.example.quoraspringboot.repositories.TagRepository;
import org.example.quoraspringboot.repositories.UserRepository;
import org.example.quoraspringboot.services.QuestionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private UserRepository userRepository;
    private TagRepository tagRepository;

    @Override
    public List<Question> getQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question createQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());

        Optional<User> user = userRepository.findById(questionDTO.getUserId());
        user.ifPresent(question::setUser);

        Set<Tag> tags = questionDTO.getTagIds().stream()
                .map(tagId -> tagRepository.findById(tagId).orElse(null))
                .filter(tag -> tag != null)
                .collect(Collectors.toSet());
        question.setTags(tags);

        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
