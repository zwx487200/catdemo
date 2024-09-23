package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Character;
import com.example.catdemo.mapper.CharacterMapper;
import com.example.catdemo.service.ICharacterService;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return queryCharacterList(character);
    }

    @Override
    public Response queryCharacterList(Character character) {
        PageHelper.startPage(1, 5);
        List<Character> characterList = characterMapper.selectByCharacter(character);
        return Response.success(characterList);
    }

    @Override
    public Response saveCharacter(Character character) {
        return null;
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
