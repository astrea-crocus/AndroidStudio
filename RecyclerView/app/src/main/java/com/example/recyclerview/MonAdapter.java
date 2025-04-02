package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MonViewHolder> {
    List<Items> mesItems;
    Context context;

    public MonAdapter(List<Items> mesItems, Context context) {
        this.mesItems = mesItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.affichage_items, parent, false);

        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        holder.img.setImageResource(mesItems.get(position).getImage());
        holder.txtTitre.setText(mesItems.get(position).getTitre());
        holder.txtDescription.setText(mesItems.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mesItems.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTitre, txtDescription;
        private ImageView img;
        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitre = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            img = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posi = getLayoutPosition();

            String titreClick = mesItems.get(posi).getTitre();
            String descriptionClick = mesItems.get(posi).getDescription();
            int imgClick = mesItems.get(posi).getImage();

            Toast.makeText(context,
                    "Titre : " + titreClick + ", " +
                    "Description : " + descriptionClick + "\n" +
                    "Img : " + imgClick, Toast.LENGTH_SHORT).show();

            Log.d("CLICK", "Titre : " + titreClick);
            Log.d("CLICK", "Description : " + descriptionClick);
            Log.d("CLICK", "Img : " + imgClick);
        }
    }

}
