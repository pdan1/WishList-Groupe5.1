package net.austreelis.wishlisht;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.room.Dao;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.Friendship;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;

public class FriendsActivity extends MainActivity {
    protected FriendshipDao friendshipDao;
    private String friendName;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bdd = WishListRoomDatabase.getDatabase(this);
        friendshipDao = bdd.friendshipDao();
        setContentView(R.layout.template_for_friend_addition);
    }

    public void addFriendRequest(View view) {
        // Go voir comment :
        // récupérer la valeur d'un champ
        this.friendName = ((EditText) findViewById(R.id.loginField)).getText().toString();
        if (this.friendName.equals("")) {
            this.generateError(R.string.errorMandatory);
            return;
        }
        // dao+load pour chercher si ca existe déjà
        this.status = friendshipDao.loadFriendshipStatus(u.getName(), this.friendName);
        // ajouter un message d'erreur generateError(R.string.ceque) quand l'entrée existe déja
        if (udao.loadUser(this.friendName).length == 0) {
            generateError(R.string.userDoesNotExist);
            return;
        }
        if (this.status != null) {
            if (this.status.equals("pending")) {
                generateError(R.string.alreadyPending);
            }
            if (this.status.equals("approved")) {
                generateError(R.string.alreadyFriends);
            }
            return;
        }
        // Chargement dans la BDD
        // Instancier Friendship
        Friendship newFriendship = new Friendship(u.getName(), this.friendName, "pending");
        // utiliser FriendshipDao et la méthode insert
        friendshipDao.insert(newFriendship);
    }

}
