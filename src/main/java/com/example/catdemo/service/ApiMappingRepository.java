package com.example.catdemo.service;

import com.example.catdemo.entity.ApiMapping;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiMappingRepository {
    ApiMapping findByUrl(String url);
}

