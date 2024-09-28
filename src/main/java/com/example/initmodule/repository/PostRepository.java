package com.example.initmodule.repository;

import com.example.initmodule.domain.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface PostRepository {

    List<Post> findAll(@Param("pageSize") String pageSize,
                       @Param("offset") String offset,
                       @Param("post") Post post);

    int countAll(@Param("post") Post post);
    Optional<Post> findById(long id);
    int savePost(Post post);
    int updatePost(Post post);
    int deletePost(Post post);

}