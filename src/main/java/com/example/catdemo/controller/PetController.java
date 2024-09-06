package com.example.catdemo.controller;


import com.example.catdemo.entity.Pet;
import com.example.catdemo.service.IPetService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-09-05
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    IPetService petService;
    
    
    @RequestMapping("/list")
    public Response list() {
        return Response.noDateSuccess();
    }
    
    @RequestMapping("/add")
    public Response add(@RequestBody Pet pet) {
        petService.add(pet);
        return Response.noDateSuccess();
    }
    
    @RequestMapping("/update")
    public Response update() {
        return Response.noDateSuccess();
    }
    
    @RequestMapping("/delete")
    public Response delete() {
        return Response.noDateSuccess();
    }

}
