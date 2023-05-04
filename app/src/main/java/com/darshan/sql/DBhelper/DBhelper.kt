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
    private val Tag = "DBhelper"
    val Table = "Student_table"
    override fun onCreate(p0: SQLiteDatabase?) {
        var Sql = "CREATE TABLE $Table (Id INT PRIMARY KEY AUTOINCREMENT, Name TEXT,Surname TEXT);"
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
        var iss = DB.insert(Table, null, Value)
        if (iss.toInt() == 1) {
            Log.e(Tag,"addStudent:================Data is not Insert")
        } else {
            Log.e(Tag,"addStudent:================Data  Insert")
        }

    }
}