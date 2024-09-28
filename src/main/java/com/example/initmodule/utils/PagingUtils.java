package com.example.initmodule.utils;

import lombok.Builder;
import lombok.Getter;

public class PagingUtils {

    public static PagingInfo getPagingInfo(int currentPage_, int pageSize_, long totalRowDataCnt) {
        /** STEP 1 */
        int pageBlockCnt = 5; // 개발자가 정하면 됨
        int pageSize = checkPageSizeValidation(pageSize_);
        int totalPageBlockCnt = calTotalPageBlockCnt(totalRowDataCnt, pageSize);
        int currentPage = checkCurrentPageValidation(currentPage_, totalPageBlockCnt);
        /** STEP 2 */
        int endPageBlock = calEndPageBlock(currentPage, pageBlockCnt);
        int startPageBlock = calStartPageBlock(endPageBlock, pageBlockCnt);
        // 유효성 검사를 더 늦게 해줘야 함
        endPageBlock = checkEndPageBlockValidation(endPageBlock, totalPageBlockCnt);
        boolean next = (currentPage != totalPageBlockCnt);

        startPageBlock = checkStartPageBlockValidation(startPageBlock);
        boolean prev = (currentPage != 1);
        /** STEP 3 */
        int startRowDataNum = (currentPage-1) * pageSize + 1;
        int endRowDataNum = startRowDataNum + pageSize -1;

        int offSet = (currentPage-1) * pageSize;

        return PagingInfo.builder()
                .pageSize(pageSize)
                .currentPage(currentPage)
                .startPageBlock(startPageBlock)
                .endPageBlock(endPageBlock)
                .startRowDataNum(startRowDataNum)
                .endRowDataNum(endRowDataNum)
                .totalPageBlockCnt(totalPageBlockCnt)
                .totalRowDataCnt(totalRowDataCnt)
                .offSet(offSet)
                .prev(prev)
                .next(next)
                .build();
    }

    private static int checkPageSizeValidation(int pageSize) {
        if (pageSize == 5 || pageSize == 10 || pageSize == 30 || pageSize == 50) {
            return pageSize;
        }
        return 10;
    }

    private static int checkCurrentPageValidation(int currentPage, int totalPageBlockCnt) {
        if (currentPage > totalPageBlockCnt)
            currentPage = totalPageBlockCnt;
        else if (currentPage < 1)
            currentPage = 1;

        return currentPage;
    }

    private static int calTotalPageBlockCnt(long totalRowDataCnt, int pageSize) {
        if (totalRowDataCnt == 0) {
            return 1;
        }
        return (int)(totalRowDataCnt + pageSize - 1) / pageSize;
    }

    private static int calEndPageBlock(int currentPage, int pageBlockCnt) {
        return ((currentPage + pageBlockCnt - 1) / pageBlockCnt) * pageBlockCnt;
    }

    private static int checkEndPageBlockValidation(int endPageBlock, int totalPageBlockCnt) {
        return Math.min(endPageBlock, totalPageBlockCnt);
    }

    private static int calStartPageBlock(int endPageBlock, int pageBlockCnt) {
        return endPageBlock - pageBlockCnt + 1;
    }

    private static int checkStartPageBlockValidation(int startPageBlock) {
        return Math.max(startPageBlock, 1);
    }


    @Getter
    @Builder
    public static class PagingInfo {
        private int pageSize;
        private int currentPage;
        private int startPageBlock;
        private int endPageBlock;
        private int startRowDataNum;
        private int endRowDataNum;
        private int totalPageBlockCnt;
        private long totalRowDataCnt;
        private int offSet;
        private boolean prev;
        private boolean next;
    }

}