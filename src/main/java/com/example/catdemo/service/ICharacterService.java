package com.example.catdemo.service;

import com.example.catdemo.entity.Character;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;


/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@Service
public interface ICharacterService {

    Response queryCharacter(Character character);

    Response queryCharacterList(Character character);

    Response saveCharacter(Character character);

    Response updateCharacter(Character character);

    Response deleteCharacter(Long id);

}
