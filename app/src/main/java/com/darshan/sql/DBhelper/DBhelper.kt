package com.darshan.sql.DBhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.nfc.Tag
import android.util.Log
import com.darshan.sql.Model.DBModel

class DBhelper(
    context: Context?,

    ) : SQLiteOpenHelper(context, "Table.db", null, 1) {
    private val TAG = "DBhelper"
    val Table_table = "Student_table"
    override fun onCreate(p0: SQLiteDatabase?) {
        var Sql = "CREATE TABLE $Table_table (Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,surname TEXT);"
        p0?.execSQL(Sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addStudents(stdData: DBModel) {
        var DB = writableDatabase
        var Value = ContentValues().apply {
            put("name", stdData.name)
            put("SurName", stdData.SurName)
        }
        var iss = DB.insert(Table_table, null, Value)
        if (iss.toInt() == -1) {
            Log.e(TAG,"addStudent:================Data is not Insert")
        } else {
            Log.e(TAG,"addStudent:================Data  Insert")
        }

    }
}