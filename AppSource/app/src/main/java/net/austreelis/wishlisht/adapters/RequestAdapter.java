package net.austreelis.wishlisht.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.R;
import net.austreelis.wishlisht.entities.User;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder> {
    private User[] users;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final Button accept;
        private final Button decline;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.UserName);
            accept = itemView.findViewById(R.id.button3);
            decline = itemView.findViewById(R.id.button4);
        }
    }
    public RequestAdapter(User[] users) {this.users = users;}
    @NonNull
    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_item, parent, false);
        return new RequestAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(users[position].getName());
    }

    @Override
    public int getItemCount() {
        return users.length;
    }
}
