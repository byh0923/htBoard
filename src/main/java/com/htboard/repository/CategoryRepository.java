package com.htboard.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htboard.dto.Category;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final String dataDir = "file/data.json";
    private static Category category;

    /**
     * json 데이터를 카테고리에 넣는다.
     * */
    public CategoryRepository() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(dataDir);
        ObjectMapper objectMapper = new ObjectMapper();
        category = objectMapper.readValue(classPathResource.getFile(), Category.class);
    }

    /**
     * 모든 카테고리 정보를 반환하는 메서드
     * */
    public Category getAllCategory() {
        return category;
    }

    /**
     * 카테고리 id로 검색 시 해당 <code>categoryId</code>를 가진 하위 모든 카테고리 정보까지 반환하는 메서드
     * */
    public List<Category> findByCategoryId(int categoryId) {
        List<Category> list = category.getChild();

        List<Category> result = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {

            if(list.get(i).getCategoryId() == categoryId) {
                result.add(list.get(i));
            }

            if (getCategories(result)) {
                return result;
            }

            List<Category> middleList = list.get(i).getChild();
            for(int j=0; j<middleList.size(); j++) {

                if(middleList.get(j).getCategoryId() == categoryId) {
                    result.add(middleList.get(j));
                }

                if (getCategories(result)) {
                    return result;
                }

            List<Category> lowerList = middleList.get(j).getChild();
            for(int k=0; k<lowerList.size(); k++) {
                    if(lowerList.get(k).getCategoryId() == categoryId) {
                        result.add(lowerList.get(k));
                    }
                }
            }
        }
        return result;
    }

    private boolean getCategories(List<Category> result) {
        return result.size() != 0;
    }

    /**
     * 카테고리 이름으로 검색 시 해당 <code>categoryName</code>을 가진 하위 모든 카테고리 정보까지 반환하는 메서드
     * */
    public List<Category> findByCategoryName(String categoryName) {

        List<Category> list = category.getChild();

        List<Category> result = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {

            if(list.get(i).getCategoryName().equals(categoryName)) {
                result.add(list.get(i));
            }

            if (getCategories(result)) {
                return result;
            }

            List<Category> middleList = list.get(i).getChild();
            for(int j=0; j<middleList.size(); j++) {

                if(middleList.get(j).getCategoryName().equals(categoryName)) {
                    result.add(middleList.get(j));
                }

                if (getCategories(result)) {
                    return result;
                }

                List<Category> lowerList = middleList.get(j).getChild();
                for(int k=0; k<lowerList.size(); k++) {

                    if(lowerList.get(k).getCategoryName().equals(categoryName)) {
                        result.add(lowerList.get(k));
                    }
                }
            }
        }
        return result;
    }
}
