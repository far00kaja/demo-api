package com.domain.models.repos;

import com.domain.models.entities.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category,Long> {
    // Paging dan Sorting dengan Spring Data JPA

    Page<Category> findByNameContains(String name, Pageable pageble);

}
