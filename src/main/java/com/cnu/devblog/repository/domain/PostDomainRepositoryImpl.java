package com.cnu.devblog.repository.domain;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.repository.persistence.post.PostRepository;
import com.cnu.devblog.repository.persistence.post.ProjectRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class PostDomainRepositoryImpl implements PostDomainRepository {
    
    private final PostRepository postRepository;
    private final ProjectRepository projectRepository;
    
    @Override
    public Page<Post> findByCreatedAtBetween(LocalDateTime startedAt, LocalDateTime endedAt,
        Pageable pageable) {
        return postRepository.findByCreatedAtBetween(startedAt, endedAt, pageable);
    }
    
    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }
    
    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }
    
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
    
    @Override
    public Page<Post> findAll(Specification<Post> specification, Pageable pageable) {
        return null;
    }
    
    @Override
    public boolean exist(Integer id) {
        return postRepository.existsById(id);
    }
    
    @Transactional
    @Override
    public Post updatePost(Integer id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow();
        post.updatePost(postRequest.getTitle(), post.getContents());
        postRepository.save(post);
        return post;
    }
}
