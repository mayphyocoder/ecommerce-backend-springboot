package com.maymart.Ecommerce.repository;

import com.maymart.Ecommerce.dto.UserInfoDto;
import com.maymart.Ecommerce.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository {
    void saveUserInfo(UserInfo userInfo);

    UserInfo getUserInfoById(int id);

    List<UserInfo> getAllUserInfo();

    UserInfo updateUserInfo(UserInfo userInfo);

    void deleteById(int id);

    void deleteAllUserInfo();

}
