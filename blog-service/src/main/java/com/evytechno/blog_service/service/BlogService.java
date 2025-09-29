package com.evytechno.blog_service.service;

import com.evytechno.blog_service.dtos.BlogRequest;
import com.evytechno.blog_service.dtos.BlogResponse;
import com.evytechno.blog_service.entity.Blog;

public interface BlogService {

    void  addBlog(BlogRequest request);

    BlogResponse getBlogById(Long id);

}
