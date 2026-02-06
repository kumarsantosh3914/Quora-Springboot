package org.example.quoraspringboot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.quoraspringboot.dtos.TagDTO;
import org.example.quoraspringboot.models.Tag;
import org.example.quoraspringboot.repositories.TagRepository;
import org.example.quoraspringboot.services.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag createTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
