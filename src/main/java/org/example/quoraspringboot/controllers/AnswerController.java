package org.example.quoraspringboot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.quoraspringboot.dtos.AnswerDTO;
import org.example.quoraspringboot.models.Answer;
import org.example.quoraspringboot.services.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping
    public List<Answer> getAllAnswersByQuestionId(@PathVariable Long questionId, @PathVariable int page, @PathVariable int size) {
        return answerService.getAnswersByQuestionId(questionId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.getAnswerById(id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDTO answerDTO) {
        Answer createdAnswer = answerService.createAnswer(answerDTO);
        return ResponseEntity.ok(createdAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.ok().build();
    };
}
