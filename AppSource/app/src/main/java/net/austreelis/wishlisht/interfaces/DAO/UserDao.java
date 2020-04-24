package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import net.austreelis.wishlisht.entities.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User u);

    @Update
    int updateUser(User ... u);

    @Query("SELECT * FROM Users WHERE userid=:userid")
    User[] loadUser(String userid);

    @Query("SELECT * FROM Users")
    User[] loadAllUsers();

    @Query("SELECT * FROM Users WHERE userid=:userId AND password=:password")
    User[] loginUser(String userId, String password);




}
