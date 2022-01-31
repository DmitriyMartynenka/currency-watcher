package com.example.cryptoapp.repo;

import com.example.cryptoapp.model.UserCoins;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCoinsRepo extends CrudRepository<UserCoins, Integer> {

    @Modifying
    @Query("delete from UserCoins us where us.coin.id=:id and us.user.id=:userId")
    void delete(@Param(value = "id") int id, @Param(value = "userId") int username);
}
