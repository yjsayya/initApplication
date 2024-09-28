package com.example.initmodule.controller.request;

import com.example.initmodule.domain.dto.PostListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostListRequest {

    private int currentPage;
    private int pageSize;
//    추가적인 조건들

    public PostListDto toDto() {
        return PostListDto.builder()
                .currentPage(this.currentPage)
                .pageSize(this.pageSize)
                // 추가적인 조건 요소들
                .build();
    }

}