package net.austreelis.wishlisht.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class User {

    public User(@NonNull String userid, @NonNull String email, @NonNull String name, @NonNull String password, @NonNull String color, @NonNull String size) {
        this.userid = userid;
        this.email = email;
        this.name = name;
        this.password = password;
        this.color = color;
        this.size = size;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userid")
    private String userid;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @ColumnInfo(name = "color", defaultValue = "black")
    private String color;

    @NonNull
    @ColumnInfo(name = "size", defaultValue = "M")
    private String size;

    @ColumnInfo(name = "pict", defaultValue = "@drawable/avatar")
    private String pict;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "interest1")
    private String interest1;

    @ColumnInfo(name = "interest2")
    private String interest2;

    @ColumnInfo(name = "interest3")
    private String interest3;

    @NonNull
    public String getUserid() { return userid; }

    public void setUserid(@NonNull String userId) {
        this.userid = userId;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getColor() {
        return color;
    }

    public void setColor(@NonNull String color) {
        this.color = color;
    }

    @NonNull
    public String getSize() {
        return size;
    }

    public void setSize(@NonNull String size) {
        this.size = size;
    }

    @NonNull
    public String getPict() {
        return pict;
    }

    public void setPict(@NonNull String pict) {
        this.pict = pict;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(@NonNull String interest1) {
        this.interest1 = interest1;
    }

    @NonNull
    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(@NonNull String interest2) {
        this.interest2 = interest2;
    }

    @NonNull
    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(@NonNull String interest3) {
        this.interest3 = interest3;
    }

}
