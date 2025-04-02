package com.example.recyclerview;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MonAdapter monAdapter;
    private RecyclerView recyclerView;
    private List<Items> mesItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mesItems = new ArrayList<>();

        mesItems.add(new Items(R.drawable.axolotl, "Axoltl",
                "L'axolotl est capable de régénérer ses organes ou ses parties du " +
                        "corps suite à un accident."));
        mesItems.add(new Items(R.drawable.cerf, "Cerf",
                "Les bois de cerf sont parmi les structures de la nature qui se " +
                        "développent le plus rapidement."));
        mesItems.add(new Items(R.drawable.chat, "Chat",
                "On pense que les chats sont les seuls mammifères à ne pas percevoir " +
                        "le goût sucré."));
        mesItems.add(new Items(R.drawable.chien, "Chien",
                "La morsure d’un chien est presque trois fois plus puissante que celle " +
                        "d’un humain."));
        mesItems.add(new Items(R.drawable.hibou, "Hibou",
                "Les hiboux ont trois paires de paupières : une pour cligner des yeux, " +
                        "une pour dormir et une pour nettoyer et protéger leurs yeux."));
        mesItems.add(new Items(R.drawable.lion, "Lion",
                "À l'inverse de toutes les autres espèces de félins, les lions " +
                        "rugissent ensemble - et même les jeunes lionceaux miaulent en choeur."));
        mesItems.add(new Items(R.drawable.tortue, "Tortue",
                "Le fossile de la plus vieille tortue date de 220 millions d’années, " +
                        "ce qui signifie que la tortue est apparue 23 millions d’années après " +
                        "les dinosaures."));
        mesItems.add(new Items(R.drawable.serpent, "Serpent",
                "20 % des serpents sont venimeux, et ces serpents peuvent tuer " +
                        "un éléphant."));
        mesItems.add(new Items(R.drawable.girafe, "Girafe",
                "Les tâches de la girafe sont uniques comme des empreintes digitales " +
                        "chez l’Homme"));

        monAdapter = new MonAdapter(mesItems, getApplicationContext());

        /*  Autre méthode :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        */

        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }

        recyclerView.setAdapter(monAdapter);

        EffetSwipe effetSwipe = new EffetSwipe(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,
                MainActivity.this, mesItems, monAdapter);
        new ItemTouchHelper(effetSwipe).attachToRecyclerView(recyclerView);

    }
}