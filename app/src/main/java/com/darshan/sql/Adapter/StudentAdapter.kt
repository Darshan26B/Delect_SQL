package com.darshan.sql.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.darshan.sql.Model.DBModel
import com.darshan.sql.R
import java.util.ArrayList

class StudentAdapter(click: (Int) -> Unit) :RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    var click= click
    lateinit var List:ArrayList<DBModel>
    class StudentHolder(itemView:View):ViewHolder(itemView){
        var id=itemView.findViewById<TextView>(R.id.txtid)
        var Name=itemView.findViewById<TextView>(R.id.txtName)
        var SurName=itemView.findViewById<TextView>(R.id.txtSurName)
        var STD=itemView.findViewById<TextView>(R.id.txtStd)
        var imgDelete = itemView.findViewById<ImageView>(R.id.imgDelete)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return StudentHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.id.text= List.get(position).id.toString()
        holder.Name.text=List.get(position).name
        holder.SurName.text=List.get(position).SurName
        holder.STD.text=List.get(position).STD

        holder.imgDelete.setOnClickListener {
                click.invoke(List.get(position).id)
        }
    }

    fun update(students: ArrayList<DBModel>) {
        List =students
        notifyDataSetChanged()
    }
    fun setStudent(list: ArrayList<DBModel>) {
        this.List=list
    }
}