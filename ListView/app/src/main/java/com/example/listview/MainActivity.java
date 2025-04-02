package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maListViewPerso = findViewById(R.id.listView);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        map = new HashMap<String, String>();
        map.put("titre", "Administrateur");
        map.put("description", "On est sérieux ici, okay ?");
        map.put("img", String.valueOf(R.drawable.admin));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Utilisateur");
        map.put("description", "Je ne suis qu'un utilisateur lambda.");
        map.put("img", String.valueOf(R.drawable.user));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Chat");
        map.put("description", "«Miaou miaou» - De si belles paroles.");
        map.put("img", String.valueOf(R.drawable.kitty));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Rose");
        map.put("description", "Lorem Ipsum");
        map.put("img", String.valueOf(R.drawable.circle));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Myrtille");
        map.put("description", "Lorem Ipsum");
        map.put("img", String.valueOf(R.drawable.square));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Femme ?");
        map.put("description", "Apparament je suis une femme.");
        map.put("img", String.valueOf(R.drawable.female));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Homme");
        map.put("description", "Un bonhomme, un vrai.");
        map.put("img", String.valueOf(R.drawable.male));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Monsieur X");
        map.put("description", "Mon identitée restera secrète.");
        map.put("img", String.valueOf(R.drawable.man));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Madame X");
        map.put("description", "Je ne suis pas disparue.");
        map.put("img", String.valueOf(R.drawable.woman));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Tête de noix");
        map.put("description", "No comment...");
        map.put("img", String.valueOf(R.drawable.acorn));
        listItem.add(map);

        SimpleAdapter monAdapter = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.affichage_item,
                new String[]{"img", "titre", "description"}, new int[]{R.id.img, R.id.titre, R.id.description});

        maListViewPerso.setAdapter(monAdapter);
    }
}