package net.austreelis.wishlisht.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "Wishlists", indices = {@Index(value = {"name","userid"}, unique = true)})
public class WishList {

    public WishList(@NonNull String name, @NonNull String userid, String desc) {
        this.name = name;
        this.userid = userid;
        this.desc = desc;
    }

    @NonNull
    @ColumnInfo(name="name")
    private String name;

    @NonNull
    @ForeignKey(entity=User.class, parentColumns = "userid", childColumns = "userid")
    @ColumnInfo(name="userid")
    private String userid;

    @ColumnInfo(name="desc")
    private String desc;

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getUserid() {
        return userid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
