package com.example.curriculumvitae2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "exprience")
data class ExprienceEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "image")
    val image:Int ,
    @ColumnInfo(name = "address")
    val address:String ,
    @ColumnInfo(name = "name")
    val name:String ,
    @ColumnInfo(name = "date_debut")
    val date_debut:String ,
    @ColumnInfo(name = "date_fin")
    val date_fin :String ,

)