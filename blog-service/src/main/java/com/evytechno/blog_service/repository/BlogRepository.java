package com.evytechno.blog_service.repository;

import com.evytechno.blog_service.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
