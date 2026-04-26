package com.example.tp15.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp15.classes.Etudiant;
import com.example.tp15.util.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class EtudiantService {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NOM, MySQLiteHelper.COLUMN_PRENOM, MySQLiteHelper.COLUMN_TELEPHONE };

    public EtudiantService(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void create(Etudiant e) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOM, e.getNom());
        values.put(MySQLiteHelper.COLUMN_PRENOM, e.getPrenom());
        values.put(MySQLiteHelper.COLUMN_TELEPHONE, e.getTelephone());
        long insertId = database.insert(MySQLiteHelper.TABLE_ETUDIANT, null,
                values);
        e.setId((int) insertId);
    }

    public void delete(Etudiant e) {
        int id = e.getId();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void update(Etudiant e) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOM, e.getNom());
        values.put(MySQLiteHelper.COLUMN_PRENOM, e.getPrenom());
        values.put(MySQLiteHelper.COLUMN_TELEPHONE, e.getTelephone());
        database.update(MySQLiteHelper.TABLE_ETUDIANT, values, MySQLiteHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(e.getId())});
    }

    public Etudiant findById(int id) {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ETUDIANT,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + id, null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Etudiant e = cursorToEtudiant(cursor);
            cursor.close();
            return e;
        }
        return null;
    }

    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_ETUDIANT,
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

    private Etudiant cursorToEtudiant(Cursor cursor) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(cursor.getInt(0));
        etudiant.setNom(cursor.getString(1));
        etudiant.setPrenom(cursor.getString(2));
        etudiant.setTelephone(cursor.getString(3));
        return etudiant;
    }
}
