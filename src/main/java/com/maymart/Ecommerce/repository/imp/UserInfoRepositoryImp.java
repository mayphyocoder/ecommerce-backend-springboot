package com.maymart.Ecommerce.repository.imp;

import com.maymart.Ecommerce.model.UserInfo;
import com.maymart.Ecommerce.repository.UserInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepositoryImp implements UserInfoRepository {

    @Autowired
    public EntityManager entityManager;


    @Override
    @Transactional
    public void saveUserInfo(UserInfo userInfo) {
        entityManager.persist(userInfo);
        entityManager.flush();
    }

    @Override
    @Transactional
    public UserInfo getUserInfoById(int id) {
        return entityManager.find(UserInfo.class, id);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        TypedQuery<UserInfo> query = entityManager.createQuery("Select s from UserInfo s", UserInfo.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public UserInfo updateUserInfo(UserInfo userInfo) {
        UserInfo userInfoResponse = entityManager.merge(userInfo);
        entityManager.flush();
        return userInfoResponse;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(getUserInfoById(id));
    }

    @Override
    @Transactional
    public void deleteAllUserInfo() {
        entityManager.createQuery("delete from UserInfo").executeUpdate();
    }
}
