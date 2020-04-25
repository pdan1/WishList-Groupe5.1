package net.austreelis.wishlisht.view_holders;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.R;

public abstract class GenericViewHolder extends RecyclerView.ViewHolder {

    public View view;

    public GenericViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }
}
