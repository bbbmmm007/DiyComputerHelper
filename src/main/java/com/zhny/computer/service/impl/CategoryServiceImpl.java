package com.zhny.computer.service.impl;


import com.zhny.computer.mapper.CategoryMapper;
import com.zhny.computer.mapper.ProductMapper;
import com.zhny.computer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;



}
