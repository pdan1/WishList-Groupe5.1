package net.austreelis.wishlisht.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;

@Database(entities = {User.class}, version=1, exportSchema = true)
public abstract class WishListRoomDatabase extends RoomDatabase {

    public abstract UserDao wordDao();

    private static volatile WishListRoomDatabase INSTANCE;

    static WishListRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WishListRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WishListRoomDatabase.class, "desiteratapp_bdd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
