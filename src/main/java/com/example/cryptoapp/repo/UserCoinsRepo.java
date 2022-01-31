package com.example.cryptoapp.repo;

import com.example.cryptoapp.dto.InfoResponse;
import com.example.cryptoapp.model.UserCoins;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCoinsRepo extends CrudRepository<UserCoins, Integer> {

    @Query("select new com.example.cryptoapp.dto.InfoResponse(c.id, u.username, (c.price/cu.registrationPrice-1)*100)" +
            "from UserCoins cu inner join cu.coin c " +
            "inner join cu.user u " +
            "where c.price/cu.registrationPrice>1.01 " +
            "or c.price/cu.registrationPrice<0.99")
    List<InfoResponse> findInfoForNotify();

    @Modifying
    @Query("delete from UserCoins us where us.coin.id=:id and us.user.id=:userId")
    void delete(@Param(value = "id") int id, @Param(value = "userId") int username);
}