package com.evytechno.blog_service.service;

import com.evytechno.blog_service.dtos.BlogRequest;
import com.evytechno.blog_service.dtos.BlogResponse;
import com.evytechno.blog_service.entity.Blog;
import com.evytechno.blog_service.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;
    @Override
    public void addBlog(BlogRequest request) {
        Blog blog = Blog.builder()
                .blogBy(request.blogBy())
                .blogDescription(request.blogDescription())
                .build();
        blogRepository.save(blog);
    }

    @Override
    public BlogResponse getBlogById(Long id) {
         Blog blog = blogRepository.findById(id)
                 .orElseThrow(()-> new RuntimeException("blog not found"));
         return  new BlogResponse(blog.getBlogBy(),blog.getBlogDescription());
    }
}
