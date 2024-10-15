package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Character;
import com.example.catdemo.mapper.CharacterMapper;
import com.example.catdemo.service.ICharacterService;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
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

    @Value("${character.deletecheck}")
    private boolean deletecheck;

    @Value("${character.addcheck}")
    private boolean addcheck;

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
        int count = 0;
        if(StringUtils.isNotBlank(character.getCharacterId())){
            Character existCharacter = characterMapper.selectById(character.getCharacterId());
            if(existCharacter!= null){
                if (!addcheck){
                    count = characterMapper.updateByIdSelective(character);
                } else {
                    return Response.error("9999", "该数据已存在");
                }
            }else {
                count = characterMapper.insertSelective(character);
            }
        } else {
            count = characterMapper.insertSelective(character);
        }
        if(count == 0){
            return Response.error("9999", "插入数据失败");
        }
        return Response.success(character);
    }

    @Override
    public Response updateCharacter(Character character) {

        // 先查询是否存在，如果不存在则新增，存在则修改
        List<Character> characterList = characterMapper.selectByCharacter(character);
        int count;
        if (CollectionUtils.isEmpty(characterList)){
            count = characterMapper.insertSelective(character);
        } else {
            count = characterMapper.updateByIdSelective(character);
        }
        if(count == 0){
            return Response.error("9999", "修改数据失败");
        }else{
            return Response.success(character);
        }
    }

    @Override
    public Response deleteCharacter(String id) {
        id = id.replace("\"","");
        // 系统参数，check 如果是true，需要校验是否存在，如果是否，不校验是否存在
        Character character = characterMapper.selectById(id);
        if (deletecheck && Objects.isNull(character)){
            return Response.error("9999", "用户不存在");
        }
        int count = characterMapper.deleteById(id);
        if (count == 0){
            return Response.error("9999", "删除数据失败");
        } else {
            return Response.noDateSuccess();
        }
    }
}
