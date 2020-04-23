package net.austreelis.wishlisht.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Wishes", primaryKeys = {"userid","list","name"})

public class Wish {

    public Wish(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ForeignKey(entity=WishList.class, parentColumns = "name", childColumns = "list")
    @ColumnInfo(name = "list")
    private int list;

    @NonNull
    @ForeignKey(entity=User.class, parentColumns = "userid", childColumns = "userid")
    private String userid;

    @NonNull
    @ColumnInfo(name = "amount")
    private int amount;

    @ColumnInfo(name = "link")
    private String link;

    @ColumnInfo(name = "wishrate")
    private int wishrate;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "pict")
    private String pict;

    @ColumnInfo(name = "desc")
    private String desc;

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setList(int list) {
        this.list = list;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setWishrate(int wishrate) {
        this.wishrate = wishrate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public int getList() {
        return list;
    }

    @NonNull
    public String getUserid() {
        return userid;
    }

    public int getAmount() {
        return amount;
    }

    public String getLink() {
        return link;
    }

    public int getWishrate() {
        return wishrate;
    }

    public int getPrice() {
        return price;
    }

    public String getPict() {
        return pict;
    }

    public String getDesc() {
        return desc;
    }
}
