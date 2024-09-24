package com.example.catdemo.controller;

import com.example.catdemo.entity.Character;
import com.example.catdemo.service.ICharacterService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    ICharacterService iCharacterService;

    @PostMapping("/queryCharacterList")
    public Response queryCharacterList(@RequestBody Character character) {
//        PageHelper.startPage(requestInfo.getPageNum(), requestInfo.getPageSize());
        return iCharacterService.queryCharacterList(character);
    }

    @PostMapping("/queryCharacter")
    public Response queryCharacter(@RequestBody Character character) {
        return iCharacterService.queryCharacter(character);
    }

    @PostMapping("/saveCharacter")
    public Response saveCharacter(@RequestBody Character character) {
        return iCharacterService.saveCharacter(character);
    }

    @PostMapping("/updateCharacter")
    public Response updateCharacter(@RequestBody Character character) {
        return iCharacterService.updateCharacter(character);
    }

    @PostMapping("/deleteCharacter")
    public Response deleteCharacter(@RequestBody Long id) {
        return iCharacterService.deleteCharacter(id);
    }



}
