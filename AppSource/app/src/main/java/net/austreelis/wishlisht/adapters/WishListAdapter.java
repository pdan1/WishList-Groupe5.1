package net.austreelis.wishlisht.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.R;
import net.austreelis.wishlisht.entities.WishList;

import org.w3c.dom.Text;

// Refactoring of code template fetched from official android documentation

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder> {

    private WishList[] dataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final TextView name, desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.WishListName);
            desc = itemView.findViewById(R.id.WishListDesc);
        }
    }

    public WishListAdapter(WishList[] myDataset) {
        dataset = myDataset;
    }

    @Override
    public WishListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(dataset[position].getName());
        holder.desc.setText(dataset[position].getDesc());
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}

