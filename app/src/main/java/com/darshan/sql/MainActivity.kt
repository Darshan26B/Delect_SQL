package com.darshan.sql

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        var list = DBhelper.getstudent()

        adapter = StudentAdapter { id ->
            var dialog =
                AlertDialog.Builder(this).setTitle("Delete").setMessage("are you sure to Delete")
                    .setPositiveButton("yes", object :
                        DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            DBhelper.delectStudent(id)
                            adapter.update(DBhelper.getstudent())
                        }
                    })
                    .setNegativeButton("No", object : OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {

                        }
                    })
                    .create()
            dialog.show()

        }
        adapter.setStudent(list)

        binding.rcvStudentList.layoutManager = LinearLayoutManager(this)
        binding.rcvStudentList.adapter = adapter

        binding.btnClick.setOnClickListener {
            var name = binding.edtName.text.toString()
            var Surname = binding.edtSurName.text.toString()
            var STD = binding.edtStd.text.toString()
          if (name.isEmpty() || Surname.isEmpty() || STD.isEmpty()) {
                Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show()
            } else {
                var data = DBModel(0, name, Surname, STD)
                DBhelper.addStudents(data)
                adapter.update(DBhelper.getstudent())
                clearEditText()
            }

        }


    }

    private fun clearEditText() {
        binding.edtName.setText("")
        binding.edtSurName.setText("")
        binding.edtStd.setText("")
    }
}