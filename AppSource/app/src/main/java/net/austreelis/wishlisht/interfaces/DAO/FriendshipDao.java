package net.austreelis.wishlisht.interfaces.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import net.austreelis.wishlisht.entities.Friendship;

@Dao
public interface FriendshipDao {
    @Insert
    void insert(Friendship fship);

    // this is a very ugly request
    @Query("SELECT status FROM friends WHERE (userid1=:userid1 AND userid2=:userid2) OR (userid1=:userid2 AND userid2=:userid1)")
    public String loadFriendshipStatus(String userid1, String userid2);

    @Query("SELECT userid1 FROM Friends WHERE userid2=:userid")
    public String[] loadFriendsWithStatus1(String userid);

    @Query("SELECT userid2 FROM Friends WHERE userid1=:userid")
    public String[] loadFriendsWithStatus2(String userid);
}
