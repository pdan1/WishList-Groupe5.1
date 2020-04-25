package net.austreelis.wishlisht.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.R;

public class WishListViewHolder extends GenericViewHolder {

    public final TextView name, desc;

    public WishListViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.WishListName);
        desc = itemView.findViewById(R.id.WishListDesc);
    }
}
