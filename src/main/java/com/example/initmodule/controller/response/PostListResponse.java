package com.example.initmodule.controller.response;

import com.example.initmodule.domain.entity.Post;
import com.example.initmodule.utils.PagingUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private List<Post> PostList;
    private PagingUtils.PagingInfo pagingInfo;

    public static PostListResponse from(List<Post> postList, PagingUtils.PagingInfo pagingInfo) {
        return new PostListResponse(postList, pagingInfo);
    }

}