package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import net.austreelis.wishlisht.entities.Access;

@Dao
public interface AccessDao {
    @Insert
    void insert(Access wl);

    @Query("SELECT perm FROM Accesses WHERE userid=:userid AND list=:list AND ownerid=:ownerid")
    public String[] loadPerm(String userid, String list, String ownerid);
}