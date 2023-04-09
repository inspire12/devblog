package com.cnu.devblog.service;

import com.cnu.devblog.model.request.PostListRequest;
import com.cnu.devblog.repository.domain.PostDomainRepository;
import com.cnu.devblog.entity.Post;
import com.cnu.devblog.exception.PostInvalidException;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.repository.persistence.post.PostSpecification;
import com.cnu.devblog.service.valid.PostValidService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDomainRepository postDomainRepository;
    private final PostValidService postValidService;

    public Post createPost(PostRequest postRequest) {
        List<String> slangList = postValidService.getSlangList();
        if (postValidService.isValidPost(slangList, postRequest.getContents())) {
            throw new PostInvalidException();
        }
        return postDomainRepository.save(postRequest.toEntity());
    }

    public Optional<Post> getPost(Integer id) {
        return postDomainRepository.findById(id);
    }

    
    public Post updatePost(Integer id, PostRequest postRequest) {
        return postDomainRepository.updatePost(id, postRequest);
    }

    public void deletePost(Integer id) {
        if (postDomainRepository.exist(id)) {
            postDomainRepository.deleteById(id);
        }
    }

    
    public Page<Post> getPosts(PostListRequest postListRequest, Pageable pageable) {
        Specification<Post> spec = (root, query, criteriaBuilder) -> null;
    
        if (postListRequest.getStartDate() != null) {
            spec = spec.and(
                PostSpecification
                    .greaterThanOrEqualTo(LocalDateTime.of(postListRequest.getStartDate(), LocalDateTime.MIN.toLocalTime()))
            );
        }
        if (postListRequest.getEndDate() != null) {
            spec = spec.and(
                PostSpecification
                    .lessThanOrEqualTo(LocalDateTime.of(postListRequest.getEndDate(), LocalDateTime.MAX.toLocalTime()))
            );
        
        }
        if (postListRequest.getTag() != null) {
            spec = spec.and(
                PostSpecification
                    .equalTo(postListRequest.getTag())
            );
        }
        return postDomainRepository.findAll(spec, pageable);
    }
}
