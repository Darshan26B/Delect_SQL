package com.darshan.sql.Model

import java.util.jar.Attributes.Name

class DBModel {
    var id :Int=0
    lateinit var name:String
    lateinit var SurName:String
    lateinit var STD:String


    constructor(id:Int, name:String,SurName:String,STD:String) {
        this.id=id
        this.name=name
        this.SurName=SurName
        this.STD=STD

    }


}