package com.example.initmodule.repository;

import com.example.initmodule.domain.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

    Optional<UserAccount> findByUsername(@Param("username") String eusernamemail);
    Optional<UserAccount> findByEmail(@Param("email") String email);
    int save(@Param("email") String email, @Param("password") String password, @Param("username") String username);
    int updateUserInfo(@Param("email") String email, @Param("password") String password, @Param("username") String username);
    int deleteUser(@Param("userId") int userId);

}