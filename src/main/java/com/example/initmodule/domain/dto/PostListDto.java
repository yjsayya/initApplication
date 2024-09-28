package com.example.initmodule.domain.dto;

import com.example.initmodule.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class PostListDto {

    private int currentPage;
    private int pageSize;
    // 추가적인 조건들

    private List<PostDto> postDtoList;

    public static Post toEntity() {
        return Post.builder()
                .content("여기다가 컨텐트")
                .title("여기다가 제목")
                .build();
    }

}