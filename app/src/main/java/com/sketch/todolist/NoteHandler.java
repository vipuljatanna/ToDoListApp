package com.sketch.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NoteHandler extends DataBaseHelper{
    public NoteHandler(Context context){
        super(context);

    }
    //CRUD C=Create R=Read U=Update D=Delete

    public boolean create(Note note){
        ContentValues contentValues = new ContentValues();

        contentValues.put("title",note.getTitle());
        contentValues.put("description",note.getDescription());

        SQLiteDatabase db  = this.getWritableDatabase();

        boolean isSuccessfull = db.insert("Note",null,contentValues) > 0;
        db.close();
        return isSuccessfull;
    }
}
