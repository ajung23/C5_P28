package com.example.w7_p2;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper{
        private static final String Database_name = "Word.db";
        public static final String Database_table = "Word_table";
        private static final int Database_ver = 1;
        public static final String Col1 = "Correct";
        public static final String Col2 = "Wrong";


        public DB(Context context){
            super(context,Database_name,null, Database_ver);

        }
        @Override
        public void onCreate(SQLiteDatabase dbb){
            String query = "CREATE TABLE " + Database_table + " ("
                    + Col1 + " TEXT,"
                    + Col2 + " TEXT)";

            dbb.execSQL(query);


        }
    public void add(String correct, String wrong) {
            SQLiteDatabase dbb = this.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(Col1,correct);
            val.put(Col2,wrong);
            dbb.insert(Database_table,null,val);
            dbb.close();

    }
    public String verify(String og) {

        SQLiteDatabase dbb = this.getReadableDatabase();
        String resul = "Correct";


        Cursor cursor = dbb.query(Database_table,null,"Wrong=?",new String[]{og},null,null,null );
        if (cursor.moveToFirst()){
            resul = "The Correct Spell is " + cursor.getString(0);



        }
        return resul;

    }




    public ArrayList<Model> showList(){
            SQLiteDatabase dbb = this.getReadableDatabase();
            Cursor cur = dbb.rawQuery("SELECT * FROM " + Database_table, null);
            ArrayList<Model> curArr = new ArrayList<>();
            if (cur.moveToFirst()){
                do{
                    curArr.add(new Model(cur.getString(0),
                            cur.getString(1)
                                ));
                }while (cur.moveToNext());
            }

            cur.close();
            return curArr;

    }
    public void update( String ntr, String nf) {


        SQLiteDatabase dbb = this.getWritableDatabase();
        ContentValues vals = new ContentValues();

        vals.put(Col1, ntr);
        vals.put(Col2, nf);

        dbb.update(Database_table, vals, "Correct=?", new String[]{ntr});
        dbb.close();
    }
    public void delete(String og){
            SQLiteDatabase dbb = this.getWritableDatabase();

            dbb.delete(Database_table, "Correct=?", new String[]{og});
            dbb.close();


    }



    @Override
    public void onUpgrade(SQLiteDatabase dbb, int old, int newv) {
        dbb.execSQL("DROP TABLE IF EXISTS " + Database_table);
        onCreate(dbb);
    }

}
