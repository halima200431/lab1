package com.example.tp15.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "etudiants.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ETUDIANT = "etudiant";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_TELEPHONE = "telephone";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ETUDIANT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NOM
            + " text not null, " + COLUMN_PRENOM
            + " text not null, " + COLUMN_TELEPHONE
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT);
        onCreate(db);
    }
}
