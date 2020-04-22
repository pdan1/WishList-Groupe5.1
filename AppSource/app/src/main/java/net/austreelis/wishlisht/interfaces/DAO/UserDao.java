package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import net.austreelis.wishlisht.entities.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User word);

    @Query("SELECT * FROM Users WHERE userid=:userid")
    public User[] loadUser(String userid);

    @Query("SELECT * FROM Users WHERE userId=:userId AND password=:password")
    public User[] loginUser(String userId, String password);


}
