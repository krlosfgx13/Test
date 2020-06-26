/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.repository;

import com.api.healthcare.model.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    
    /*
        @Query("FROM OrderDetails WHERE orderid = ?1 AND productid = ?2")
        List<OrderDetails> findByOrderAndCustId(int orderid, int productid);
    
        @Query("FROM OrderDetails WHERE orderid = ?1 AND description = ?2")
        List<OrderDetails> findByOrderAndDescription(int orderid, String description);
    */    
    //FROM ClassName.
    @Query("FROM UserAccount WHERE username = ?1")
    UserAccount findByUserName(String username);
    
    @Query("SELECT password FROM UserAccount WHERE username = ?1")
    String findPassword(String username);
}
