package com.example.lab15.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab15.classes.Etudiant;
import com.example.lab15.util.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class EtudiantService {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NOM, MySQLiteHelper.COLUMN_PRENOM };

    public EtudiantService(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Etudiant createEtudiant(String nom, String prenom) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOM, nom);
        values.put(MySQLiteHelper.COLUMN_PRENOM, prenom);
        long insertId = database.insert(MySQLiteHelper.TABLE_ETUDIANTS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ETUDIANTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Etudiant newEtudiant = cursorToEtudiant(cursor);
        cursor.close();
        return newEtudiant;
    }

    public void deleteEtudiant(Etudiant etudiant) {
        long id = etudiant.getId();
        database.delete(MySQLiteHelper.TABLE_ETUDIANTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_ETUDIANTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Etudiant etudiant = cursorToEtudiant(cursor);
            etudiants.add(etudiant);
            cursor.moveToNext();
        }
        cursor.close();
        return etudiants;
    }

    public Etudiant getEtudiantById(int id) {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ETUDIANTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + id, null,
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Etudiant etudiant = cursorToEtudiant(cursor);
            cursor.close();
            return etudiant;
        }
        return null;
    }

    private Etudiant cursorToEtudiant(Cursor cursor) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(cursor.getInt(0));
        etudiant.setNom(cursor.getString(1));
        etudiant.setPrenom(cursor.getString(2));
        return etudiant;
    }
}
