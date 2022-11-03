package com.htboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    /** 
     * 카테고리 id
     * */
    private int categoryId;
    /** 
     * 카테고리 이름
     * */
    private String categoryName;
    /** 
     * 카테고리 부모 카테고리 id
     * */
    private int parentId;
    /** 
     * 카테고리 하위 카테고리 목록
     * */
    private List<Category> child;
    /** 
     * 카테고리 해당 게시판 정보
     * */
    private List<Board> boards;

}

