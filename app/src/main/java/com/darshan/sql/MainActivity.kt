package com.darshan.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darshan.sql.DBhelper.DBhelper
import com.darshan.sql.Model.DBModel
import com.darshan.sql.databinding.ActivityMainBinding
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding
   lateinit var DBhelper:DBhelper
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       DBhelper= DBhelper(this)
       binding.btnClick.setOnClickListener {
           var Name=binding.edtName.text.toString()
           var Surname=binding.edtSurName.text.toString()

           var data=DBModel(0,Name,Surname)
       }
    }
}