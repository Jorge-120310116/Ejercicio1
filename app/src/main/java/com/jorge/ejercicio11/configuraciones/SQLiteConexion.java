package com.jorge.ejercicio11.configuraciones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper
{
    public SQLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase)
    {
        sqliteDatabase.execSQL(Transacciones.CREATETABLEPERSONAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int i, int i1){
        sqliteDatabase.execSQL(Transacciones.DROPTABLEPERSONAS);
        onCreate(sqliteDatabase);
    }

}
