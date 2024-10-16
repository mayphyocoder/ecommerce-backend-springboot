package com.maymart.Ecommerce.service;

import com.maymart.Ecommerce.dto.UserInfoDto;
import com.maymart.Ecommerce.model.UserInfo;
import com.maymart.Ecommerce.repository.imp.UserInfoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepositoryImp userInfoRepository;

    public void addUserInfo(UserInfoDto userinfoDto){
        UserInfo userInfo = new UserInfo();
        userInfo.setId((userinfoDto.getId()));
        userInfo.setName((userinfoDto.getName()));
        userInfo.setEmail(userinfoDto.getEmail());
        userInfo.setPassword(userinfoDto.getPassword());
        userInfoRepository.saveUserInfo(userInfo);

    }

    public UserInfoDto getUserInfo(int id){
        UserInfo userInfo = userInfoRepository.getUserInfoById(id);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setName(userInfo.getName());
        userInfoDto.setEmail(userInfo.getEmail());
        userInfoDto.setPassword(userInfo.getPassword());
        return userInfoDto;
    }

    public List<UserInfoDto> getAllUserInfo(){
        List<UserInfo> userInfoList = userInfoRepository.getAllUserInfo();
        return userInfoList.stream().map(userInfo -> {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(userInfo.getId());
            userInfoDto.setName(userInfo.getName());
            userInfoDto.setEmail(userInfo.getEmail());
            userInfoDto.setPassword(userInfo.getPassword());
            return userInfoDto;
        }).toList();
    }

    public UserInfo updateUserInfo(UserInfoDto userInfoDto){
            UserInfo userInfo = new UserInfo();
            userInfo.setId(userInfoDto.getId());
            userInfo.setName(userInfoDto.getName());
            userInfo.setEmail(userInfoDto.getEmail());
            userInfo.setPassword(userInfoDto.getPassword());
            userInfo = userInfoRepository.updateUserInfo(userInfo);

            UserInfo userInfoResponse = new UserInfo();
            userInfoResponse.setId(userInfo.getId());
            userInfoResponse.setName(userInfo.getName());
            userInfoResponse.setEmail(userInfo.getEmail());
            userInfoResponse.setPassword(userInfo.getPassword());
            return userInfoResponse;
    }

    public void deleteUserInfo(int id){
        userInfoRepository.deleteById(id);

    }

    public void deleteAllUserInfo(){
        userInfoRepository.deleteAllUserInfo();

    }
}
