package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Babynoteinfo;
import com.example.catdemo.entity.BabynoteinfoExample;
import com.example.catdemo.mapper.BabynoteinfoMapper;
import com.example.catdemo.service.BabynoteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宝宝记 服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-04 16:54
 */
@Service
public class BabynoteinfoServiceImpl implements BabynoteinfoService {

    @Autowired
    private BabynoteinfoMapper babynoteinfoMapper;

    @Override
    public void addBabynoteinfo(Babynoteinfo babynoteinfo) {
        babynoteinfoMapper.insertSelective(babynoteinfo);
    }

    @Override
    public void deleteBabynoteinfo(String id) {
    }

    @Override
    public void updateBabynoteinfo(Babynoteinfo babynoteinfo) {
        babynoteinfoMapper.updateByPrimaryKeySelective(babynoteinfo);
    }

    @Override
    public Babynoteinfo getBabynoteinfoById(String id) {
        return babynoteinfoMapper.selectByPrimaryKey(id);
    }

    /**
     * @param babynoteinfo
     * @return
     */
    @Override
    public List<Babynoteinfo> getAllBabynoteinfos(Babynoteinfo babynoteinfo) {
        BabynoteinfoExample example = new BabynoteinfoExample();
        return babynoteinfoMapper.selectByExample(example);
    }

    @Override
    public void batchAddBabynoteinfos(List<Babynoteinfo> babynoteinfos) {
        for (Babynoteinfo babynoteinfo : babynoteinfos) {
            babynoteinfoMapper.insert(babynoteinfo);
        }
    }

    @Override
    public void batchDeleteBabynoteinfos(List<String> ids) {

    }

    @Override
    public void batchUpdateBabynoteinfos(List<Babynoteinfo> babynoteinfos) {

    }
}

