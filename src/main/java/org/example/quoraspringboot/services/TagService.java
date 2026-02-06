package org.example.quoraspringboot.services;

import org.example.quoraspringboot.dtos.TagDTO;
import org.example.quoraspringboot.models.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> getAllTags();
    Optional<Tag> getTagById(Long id);
    Tag createTag(TagDTO tagDTO);
    void deleteTag(Long id);
}
