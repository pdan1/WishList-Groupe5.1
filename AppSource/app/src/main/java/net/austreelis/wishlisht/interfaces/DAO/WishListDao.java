package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.entities.WishList;

@Dao
public interface WishListDao {
    @Insert
    void insert(WishList wl);

    @Query("SELECT * FROM Wishlists WHERE userid=:userid")
    public WishList[] loadWishListsFromUser(String userid);
}
