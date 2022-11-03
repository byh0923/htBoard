package com.htboard.controller;

import com.htboard.dto.Category;
import com.htboard.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 전체 카테고리 목록을 조회하는 메서드
     * @return <code>List<Category></code>로 카테고리 정보를 담은 리스트
     * */
    @GetMapping("/board")
    public Category getAllCategory() {
        return categoryService.getAllCategory();
    }

    /**
     * 카테고리 검색을 하는 메서드로 <code>categoryId</code>가 숫자인지 문자인지 구분 후
     * 각각 문자로 검색하는 메서드, 숫자로 검색하는 메서드로 보냄.
     * @return <code>List<Category></code>로 카테고리 정보를 담은 리스트
     * */
    @GetMapping("/board/{categoryId}")
    public List<Category> findByBoardCategory(@PathVariable String categoryId) throws IOException {

        if(!isStringDouble(categoryId)) {
            // 문자
            return categoryService.findByBoardCategoryName(categoryId);
        }
        // 숫자
        return categoryService.findByBoardCategoryId(Integer.parseInt(categoryId));
    }

    /**
     * 숫자인지 문자인지 확인하는 메서드
     * */
    public static boolean isStringDouble(String categoryId) {
        try {
            Double.parseDouble(categoryId);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
