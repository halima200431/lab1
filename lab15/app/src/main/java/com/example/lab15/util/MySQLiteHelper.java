package com.example.lab15.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Nom de la base de données
    private static final String DATABASE_NAME = "gestion_etudiants.db";
    // Version de la base de données
    private static final int DATABASE_VERSION = 1;

    // Table Etudiants
    public static final String TABLE_ETUDIANTS = "etudiants";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_PRENOM = "prenom";

    // Commande de création de la table
    private static final String DATABASE_CREATE = "create table "
            + TABLE_ETUDIANTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NOM
            + " text not null, " + COLUMN_PRENOM
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // Exécution de la commande de création
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En cas de mise à jour, on supprime la table existante et on la recrée
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANTS);
        onCreate(db);
    }
}
