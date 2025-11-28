package com.webfluxapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webfluxapp.model.Tutorial;
import com.webfluxapp.repository.TutorialRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialService {

  @Autowired
  TutorialRepository tutorialRepository;

  public Flux<Tutorial> findAll() {
    return tutorialRepository.findAll();
  }

  public Flux<Tutorial> findByTitleContaining(String title) {
    return tutorialRepository.findByTitleContaining(title);
  }

  public Mono<Tutorial> findById(int id) {
    return tutorialRepository.findById(id);
  }

  public Mono<Tutorial> save(Tutorial tutorial) {
    return tutorialRepository.save(tutorial);
  }

  public Mono<Tutorial> update(int id, Tutorial tutorial) {
      return tutorialRepository.findById(id)
          .flatMap(existing -> {
              existing.setTitle(tutorial.getTitle());
              existing.setDescription(tutorial.getDescription());
              existing.setPublished(tutorial.isPublished());
              return tutorialRepository.save(existing);
          })
          .switchIfEmpty(Mono.empty());
  }

  public Mono<Void> deleteById(int id) {
    return tutorialRepository.deleteById(id);
  }

  public Mono<Void> deleteAll() {
    return tutorialRepository.deleteAll();
  }

  public Flux<Tutorial> findByPublished(boolean isPublished) {
    return tutorialRepository.findByPublished(isPublished);
  }
}
