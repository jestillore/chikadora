package com.jillberthestillore.chikadora.components;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jillberthestillore.chikadora.factories.ModelFactory;
import com.jillberthestillore.chikadora.models.Model;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "chikadora";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	public void insert(Model model) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = model.getContentValues();
		db.insert(model.getTable(), null, values);
		db.close();
	}
	
	public Model get(Model model) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(model.getTable(), model.getFields(), "id = ?", new String [] {
			String.valueOf(model.getId())
		}, null, null, null, null);
		if(cursor != null)
			cursor.moveToFirst();
		model.setCursor(cursor);
		return model;
	}
	
	public ArrayList<Model> getAll(String table) {
		ArrayList<Model> models = new ArrayList<Model>();
		String selectQuery = "SELECT  * FROM " + table;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Model model = ModelFactory.create(table);
				model.setCursor(cursor);
				models.add(model);
			} while (cursor.moveToNext());
		}
		return models;
	}
	
	public int update(Model model) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = model.getContentValues();

		return db.update(model.getTable(), values, "id = ?", new String [] {
			String.valueOf(model.getId())
		});
	}
	
	public void delete(Model model) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(model.getTable(), "id = ?", new String [] {
			String.valueOf(model.getId())
		});
		db.close();
	}
	
	public int count(String table) {
		String countQuery = "SELECT  * FROM " + table;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		return cursor.getCount();
	}
	
}
