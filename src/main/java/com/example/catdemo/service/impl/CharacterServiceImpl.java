package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Character;
import com.example.catdemo.mapper.CharacterMapper;
import com.example.catdemo.service.ICharacterService;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public Response queryCharacter(Character character) {
        List<Character> characterList = characterMapper.selectByCharacter(character);
        if(characterList.size() > 1){
            return Response.error("9999", "查询结果有多个");
        }
        return queryCharacterList(character);
    }

    @Override
    public Response queryCharacterList(Character character) {
        PageHelper.startPage(character.getPageNum(), character.getPageSize());
        List<Character> characterList = characterMapper.selectByCharacter(character);
        PageInfo<Character> pageInfo = new PageInfo<>(characterList);
        return Response.success(characterList,pageInfo.getTotal());
    }

    @Override
    public Response saveCharacter(Character character) {
        // 查询是否已经存在
        if(StringUtils.isNotBlank(character.getCharacterId())){
            Character existCharacter = characterMapper.selectById(character.getCharacterId());
            if(existCharacter!= null){
                return Response.error("9999", "该数据已存在");
            }else {
                //character.setCharacterId(UUID.randomUUID().toString());
                int count = characterMapper.insertSelective(character);
                if(count == 0){
                    return Response.error("9999", "插入数据失败");
                }
            }
        } else {
            character.setCharacterId(UUID.randomUUID().toString());
            int count = characterMapper.insertSelective(character);
            if(count == 0){
                return Response.error("9999", "插入数据失败");
            }
        }
        return Response.success(character);
    }

    @Override
    public Response updateCharacter(Character character) {
        return null;
    }

    @Override
    public Response deleteCharacter(Long id) {
        return null;
    }
}
