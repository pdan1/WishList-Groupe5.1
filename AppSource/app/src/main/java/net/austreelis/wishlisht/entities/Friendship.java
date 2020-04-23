package net.austreelis.wishlisht.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Friends", primaryKeys =  {"userid1", "userid2"})
public class Friendship {

    public Friendship(@NonNull String userid1, @NonNull String userid2, @NonNull String status) {
        this.userid1 = userid1;
        this.userid2 = userid2;
        this.status = status;
    }

    @NonNull
    @ForeignKey(entity=User.class, parentColumns = "userid", childColumns = "userid1")
    @ColumnInfo(name="userid1")
    private String userid1;

    @NonNull
    @ForeignKey(entity=User.class, parentColumns = "userid", childColumns = "userid2")
    @ColumnInfo(name="userid2")
    private String userid2;

    @NonNull
    @ColumnInfo(name="status")
    private String status;

    @NonNull
    public String getUserid1() {
        return userid1;
    }

    public void setUserid1(@NonNull String userid1) {
        this.userid1 = userid1;
    }

    @NonNull
    public String getUserid2() {
        return userid2;
    }

    public void setUserid2(@NonNull String userid2) {
        this.userid2 = userid2;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }
}
