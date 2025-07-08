package com.example.catdemo.service.impl;

import com.example.catdemo.service.CookingStepsService;
import com.example.catdemo.entity.CookingSteps;
import com.example.catdemo.mapper.CookingStepsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 烹饪步骤表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
@Service
public class CookingStepsServiceImpl extends ServiceImpl<CookingStepsMapper, CookingSteps> implements CookingStepsService {

}
