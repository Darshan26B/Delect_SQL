package com.darshan.sql

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.darshan.sql.Adapter.StudentAdapter
import com.darshan.sql.DBhelper.DBhelper
import com.darshan.sql.Model.DBModel
import com.darshan.sql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var DBhelper: DBhelper
    lateinit var adapter: StudentAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DBhelper = DBhelper(this)
        binding.btnClick.setOnClickListener {
            var name = binding.edtName.text.toString()
            var Surname = binding.edtSurName.text.toString()
            var STD = binding.edtStd.text.toString()
            var data = DBModel(0, name, Surname, STD)
            if (name.isEmpty() || Surname.isEmpty()||STD.isEmpty()) {
                Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show()
            }  else {
                DBhelper.addStudents(data)
                adapter.update(DBhelper.getstudent())
                clearEditText()
            }


        }
        var List = DBhelper.getstudent()
        adapter = StudentAdapter(List)
        binding.rcvStudentList.layoutManager=LinearLayoutManager(this)
        binding.rcvStudentList.adapter=adapter
    }
    private fun clearEditText() {
        binding.edtName.setText("")
        binding.edtSurName.setText("")
        binding.edtStd.setText("")
    }
}