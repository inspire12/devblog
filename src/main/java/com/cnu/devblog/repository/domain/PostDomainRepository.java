package com.cnu.devblog.repository.domain;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.request.PostRequest;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

public interface PostDomainRepository {
    
    
    Page<Post> findByCreatedAtBetween(LocalDateTime startedAt, LocalDateTime endedAt,
        Pageable pageable);
    
    Optional<Post> findById(Integer id);
    
    void deleteById(Integer id);
    
    Post save(Post post);
    
    Page<Post> findAll(Specification<Post> specification, Pageable pageable);
    
    boolean exist(Integer id);
    
    @Transactional
    Post updatePost(Integer title, PostRequest contents);
}
