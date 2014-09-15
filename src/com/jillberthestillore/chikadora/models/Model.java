package com.jillberthestillore.chikadora.models;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class Model {
	
	public abstract ContentValues getContentValues();

	public abstract void setCursor(Cursor cursor);

	public abstract String [] getFields();

	public abstract String getTable();

	public abstract int getId();
	
}
