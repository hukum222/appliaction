package com.hskumar.appliaction.dao;

import com.hskumar.appliaction.model.Status;
import com.hskumar.appliaction.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStatusRepository extends JpaRepository<Status , Integer> {
    @Query(value = "Select * from tbl_user where username = :username and status_id = 1", nativeQuery = true)
    public List<Users> findByUsername(String username);

    @Query(value = "select * from tbl_user where user_id = :userId and status_id = 1", nativeQuery = true)
    public List<Users> getUserByUserId(int userId);

    @Query(value = "select * from tbl_user where status_id = 1", nativeQuery = true)
    public List<Users> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId",
            countQuery = "SELECT count(*) FROM tbl_user", nativeQuery = true)
    public void deleteUserByUserId(int userId);
}
