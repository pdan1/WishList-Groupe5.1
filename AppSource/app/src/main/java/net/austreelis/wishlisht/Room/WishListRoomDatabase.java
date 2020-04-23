package net.austreelis.wishlisht.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import net.austreelis.wishlisht.entities.Access;
import net.austreelis.wishlisht.entities.Friendship;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.entities.Wish;
import net.austreelis.wishlisht.entities.WishList;
import net.austreelis.wishlisht.interfaces.DAO.AccessDao;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
import net.austreelis.wishlisht.interfaces.DAO.WishDao;
import net.austreelis.wishlisht.interfaces.DAO.WishListDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Access.class, Friendship.class, Wish.class, WishList.class}, version=2, exportSchema = true)
public abstract class WishListRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract FriendshipDao friendshipDao();
    public abstract WishDao wishDao();
    public abstract WishListDao wishListDao();
    public abstract AccessDao accessDao();

    private static volatile WishListRoomDatabase INSTANCE;

    public static WishListRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WishListRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WishListRoomDatabase.class, "desiteratapp_bdd")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
