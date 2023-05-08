package com.darshan.sql.DBhelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.nfc.Tag
import android.util.Log
import com.darshan.sql.Model.DBModel
import java.util.jar.Attributes.Name

class DBhelper(
    context: Context?,

    ) : SQLiteOpenHelper(context, "Table.db", null, 1) {
    private val TAG = "DBhelper"
    val Table_table = "Student_table"
    override fun onCreate(p0: SQLiteDatabase?) {
        var Sql = "CREATE TABLE $Table_table (Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,surname TEXT,STD TEXT);"
        p0?.execSQL(Sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addStudents(stdData: DBModel) {
        var DB = writableDatabase
        var Value = ContentValues().apply {
            put("name", stdData.name)
            put("SurName", stdData.SurName)
            put ("STD",stdData.STD)
        }
        var iss = DB.insert(Table_table, null, Value)
        if (iss.toInt() == -1) {
            Log.e(TAG,"addStudent:================Data is not Insert")
        } else {
            Log.e(TAG,"addStudent:================Data  Insert")
        }

        }
    fun getstudent():ArrayList<DBModel> {
        var studentlist = ArrayList<DBModel>()
        var DB = readableDatabase
        var SQL = "SELECT * FROM $Table_table"
        var cursor:Cursor=DB.rawQuery(SQL,null)
        cursor.moveToFirst()

        for (i in 0..cursor.count-1) {
            var id =cursor.getInt(0)
            var Name=cursor.getString(1)
            var SurName=cursor.getString(2)
            var STD=cursor.getString(3)
            var model=DBModel(id,Name,SurName,STD)
            studentlist.add(model)
            cursor.moveToNext()
        }
        return  studentlist

    }
}