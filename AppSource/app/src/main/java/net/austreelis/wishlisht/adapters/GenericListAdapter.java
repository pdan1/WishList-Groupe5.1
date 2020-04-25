package net.austreelis.wishlisht.adapters;

import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.view_holders.GenericViewHolder;

import java.util.ArrayList;

public abstract class GenericListAdapter<T, TDAO, VH extends GenericViewHolder> extends RecyclerView.Adapter<VH>{
    protected ArrayList<T> dataset;
    protected User u, ou;
    protected TDAO dao;
    protected Class destination_activity;

    public GenericListAdapter(ArrayList<T> myDataset, User u, User ou, TDAO dao, Class destination_activity) {
        dataset = myDataset;
        this.u = u;
        this.ou = ou;
        this.dao = dao;
    }

    public void updateDataSet(ArrayList<T> myDataset){
        dataset = myDataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


}
