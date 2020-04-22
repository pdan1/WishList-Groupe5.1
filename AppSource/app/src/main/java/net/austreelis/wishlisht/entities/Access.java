package net.austreelis.wishlisht.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "Accesses", indices = {@Index(value = {"userid", "list", "ownerid"}, unique = true)})

public class Access {

    public Access(@NonNull String userid, @NonNull String list, @NonNull String ownerid, @NonNull String perm) {
        this.userid = userid;
        this.list = list;
        this.ownerid = ownerid;
        this.perm = perm;
    }

    @NonNull
    @ForeignKey(entity=User.class, parentColumns = "userid", childColumns = "userid")
    @ColumnInfo(name="userid")
    private String userid;

    @NonNull
    @ForeignKey(entity=WishList.class, parentColumns = "name", childColumns = "list")
    @ColumnInfo(name="list")
    private String list;

    @NonNull
    @ForeignKey(entity=WishList.class, parentColumns = "userid", childColumns = "ownerid")
    @ColumnInfo(name="ownerid")
    private String ownerid;


    @NonNull
    @ColumnInfo(name="perm")
    private String perm;

    @NonNull
    public String getUserid() {
        return userid;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }

    @NonNull
    public String getList() {
        return list;
    }

    public void setList(@NonNull String list) {
        this.list = list;
    }

    @NonNull
    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(@NonNull String ownerid) {
        this.ownerid = ownerid;
    }

    @NonNull
    public String getPerm() {
        return perm;
    }

    public void setPerm(@NonNull String perm) {
        this.perm = perm;
    }
}
