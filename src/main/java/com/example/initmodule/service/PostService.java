package com.example.initmodule.service;

import com.example.initmodule.controller.response.PostListResponse;
import com.example.initmodule.domain.dto.PostDto;
import com.example.initmodule.domain.dto.PostListDto;
import com.example.initmodule.domain.entity.Post;
import com.example.initmodule.repository.PostRepository;
import com.example.initmodule.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /** 목록 불러오기 */
    public PostListResponse getPostList(PostListDto postListDto) {
        int currentPage = postListDto.getCurrentPage();
        int pageSize = postListDto.getPageSize();
//        int totalRowData = postRepository.countAll();
//        PagingUtils.PagingInfo pagingInfo = PagingUtils.getPagingInfo(currentPage, pageSize, totalRowData);

        return null;
    }

    /** 게시글 가져오기 */
//    public PostDto getPost(long postId) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new IllegalArgumentException("No Such Post"));
//
//        return PostDto.from(post);
//    }

}