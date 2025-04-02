package com.example.monsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteMaDataBase extends SQLiteOpenHelper {
    public static final String BASE_NOM = "MaBase.db";
    public static final int BASE_VERSION = 5;

    public static final String NOM_TABLE = "tabClients";
    public static final String COL0 = "idClients";
    public static final String COL1 = "nom";
    public static final String COL2 = "prenom";
    public static final String COL3 = "age";
    private Context context;

    public SQLiteMaDataBase(Context context) {
        super(context, BASE_NOM, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "CREATE TABLE " + NOM_TABLE + " ("
                + COL0 + " integer primary key autoincrement,"
                + COL1 + " text not null, "
                + COL2 + " text not null, "
                + COL3 + " integer not null);";
        Log.d("DEBUG DataBase", "strSql : " + strSql);

        db.execSQL(strSql);
        Log.d("DEBUG DataBase", "Création de la base de donnée OK - " + NOM_TABLE);
    }

    public void insertionClients(String NOM, String PRENOM, Integer AGE) {
        NOM = NOM.replace("'", " ");
        PRENOM = PRENOM.replace("'", " ");

        String strSql = "INSERT INTO " + NOM_TABLE + " (" + COL1 + ", " + COL2 + ", " + COL3 + ")"
                + " VALUES ('" + NOM + "', '" + PRENOM + "', " + AGE + ");";
        Log.d("DEBUG DataBase", "StrSql insert : " + strSql);

        getWritableDatabase().execSQL(strSql);
        Log.d("DEBUG DataBase", "insertionClients(), insertion OK");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSql = "DROP TABLE IF EXISTS " + NOM_TABLE + ";";
        db.execSQL(strSql);
        Log.d("DEBUG DataBase", "Requête SQL dans Upgrade : " + strSql);

        onCreate(db);
        Log.d("DEBUG DataBase", "Méthode Upgrade CALL : " + NOM_TABLE);
    }

    public Cursor lireTable() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor monCurseur = db.rawQuery("SELECT * FROM " + NOM_TABLE, null);
        return monCurseur;
    }

    public Cursor lireTable(Integer age) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor monCurseur = db.rawQuery("SELECT * FROM " + NOM_TABLE +
                        " WHERE " + COL3 + " = " + age + ";",
                null);
        return monCurseur;
    }

    public Cursor lireTable(String nom) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor monCurseur = db.rawQuery("SELECT * FROM " + NOM_TABLE +
                " WHERE " + COL1 + " = '" + nom  + "';", null);
        return monCurseur;
    }

}