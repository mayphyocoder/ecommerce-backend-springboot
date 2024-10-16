package com.maymart.Ecommerce.controller;

import com.maymart.Ecommerce.dto.UserInfoDto;
import com.maymart.Ecommerce.model.UserInfo;
import com.maymart.Ecommerce.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoController {

    @Autowired
    private UserInfoService userinfoService;

    @PostMapping("/addUserInfo")
    public String addUserInfo(@RequestBody UserInfoDto userinfoDto){
        userinfoService.addUserInfo(userinfoDto);
        return "User information added successfully";
    }

    @GetMapping("/getUserInfo")
    public UserInfoDto getUserInfo(@RequestParam int id){
        return userinfoService.getUserInfo(id);
    }

    @GetMapping("/getAlluserInfo")
    public List<UserInfoDto> getAllUserInfo(){
        System.out.println("Controller Work");
        return userinfoService.getAllUserInfo();
    }

    @PutMapping("/updateUserInfo")
    public UserInfo updateUserInfo(@RequestBody UserInfoDto userInfoDto){
        return userinfoService.updateUserInfo(userInfoDto);
    }

    @DeleteMapping("/deleteUserInfo")
    public String deleteUserInfo(@RequestParam int id){
        userinfoService.deleteUserInfo(id);
        System.out.println(id);
        return "User information deleted successfully";
    }

    @DeleteMapping("/deleteAllUserInfo")
    public String deleteAllUserInfo(){
        userinfoService.deleteAllUserInfo();
        return "All User information deleted successfully";
    }
}
