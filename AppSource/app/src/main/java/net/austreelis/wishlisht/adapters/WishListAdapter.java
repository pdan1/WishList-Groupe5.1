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
import net.austreelis.wishlisht.view_holders.WishListViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;

// Refactoring of code template fetched from official android documentation

public class WishListAdapter extends GenericListAdapter<WishList, WishListDao, WishListViewHolder> {


    public WishListAdapter(ArrayList<WishList> myDataset, User u, User ou, WishListDao dao) {
        super(myDataset, u, ou, dao, ProfileActivity.class);
    }

    @Override
    public WishListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item, parent, false);
        return new WishListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WishListViewHolder holder, int position) {

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
                dao.delete(currentWishList);
                dataset.remove(position);
                updateDataSet(dataset);
                notifyDataSetChanged();
            }
        });
    }

}

