package com.example.monsqlite;

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
        View view = layoutInflater.inflate(R.layout.affichage_item, parent, false);

        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        holder.id.setText(mesItems.get(position).getId());
        holder.nom.setText(mesItems.get(position).getNom());
        holder.prenom.setText(mesItems.get(position).getPrenom());
        holder.age.setText(mesItems.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return mesItems.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView id, nom, prenom, age;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            nom = itemView.findViewById(R.id.txtNom);
            prenom = itemView.findViewById(R.id.txtPrenom);
            age = itemView.findViewById(R.id.txtAge);
        }

        @Override
        public void onClick(View v) {
            int posi = getLayoutPosition();

            String idClick = mesItems.get(posi).getId();
            String nomClick = mesItems.get(posi).getNom();
            String prenomClick = mesItems.get(posi).getPrenom();
            String ageClick = mesItems.get(posi).getId();

            Log.d("CLICK", "ID : " + idClick);
            Log.d("CLICK", "Nom : " + nomClick);
            Log.d("CLICK", "Prénom : " + prenomClick);
            Log.d("CLICK", "Âge : " + ageClick);

        }
    }

}
