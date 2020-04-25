package net.austreelis.wishlisht.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import net.austreelis.wishlisht.ProfileActivity;
import net.austreelis.wishlisht.R;
import net.austreelis.wishlisht.WishListCollectionActivity;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.entities.WishList;
import net.austreelis.wishlisht.interfaces.DAO.WishListDao;

import org.w3c.dom.Text;

import java.util.ArrayList;

// Refactoring of code template fetched from official android documentation

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder> {

    private ArrayList<WishList> dataset;
    private User u, ou;
    private WishListDao wldao;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name, desc;
        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.WishListName);
            desc = itemView.findViewById(R.id.WishListDesc);
            view = itemView;
        }
    }

    public WishListAdapter(ArrayList<WishList> myDataset, User u, User ou, WishListDao dao) {
        dataset = myDataset;
        this.u = u;
        this.ou = ou;
        this.wldao = dao;
    }

    @Override
    public WishListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        WishList currentWishList = dataset.get(position);

        holder.name.setText(currentWishList.getName());
        holder.desc.setText(currentWishList.getDesc());

        holder.view.findViewById(R.id.goToWishButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), ProfileActivity.class);
                it.putExtra("current_wishlist",(new Gson()).toJson(currentWishList));
                it.putExtra("user", (new Gson()).toJson(u));
                it.putExtra("observed_user", (new Gson()).toJson(ou));
                v.getContext().startActivity(it);
            }
        });

        holder.view.findViewById(R.id.deleteWishlistButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wldao.delete(currentWishList);
                dataset.remove(position);
                updateDataSet(dataset);
                notifyDataSetChanged();
            }
        });
    }

    public void updateDataSet(ArrayList<WishList> myDataset){
        dataset = myDataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

