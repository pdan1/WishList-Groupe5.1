package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import net.austreelis.wishlisht.entities.Wish;

@Dao
public interface WishDao {

    @Insert
    void insert(Wish wish);

    @Query("SELECT * FROM Wishes WHERE list=:list")
    public Wish[] loadWishesFromList(String list);

    @Query("SELECT * FROM Wishes WHERE list=:list AND name=:name AND userid=:userid")
    public Wish[] loadSingleWish(String list, String name, String userid);


}
