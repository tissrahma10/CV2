package com.example.curriculumvitae2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception

private var imageExprience: ImageButton? = null
private var address: TextInputLayout? = null
private var name: TextInputLayout? = null
private var date_debut : TextInputLayout? = null
private var date_fin: TextInputLayout? = null
private var datedebut : TextInputEditText? = null
private var datefin: TextInputEditText? = null
private  var toolbar : Toolbar? = null
private var save : Button? = null




var counter: Int = 0
class Exprience : AppCompatActivity() {
    lateinit var dataBase: AppDataBase
    lateinit var champList: MutableList<ExprienceEntity>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exprience)
        dataBase = AppDataBase.getDatabase(this)

        toolbar = findViewById(R.id.toolbar2);
        address = findViewById(R.id.adress)
        name = findViewById(R.id.campanyname)
        date_debut = findViewById(R.id.datedebut)
        date_fin = findViewById(R.id.datefin)
        save = findViewById(R.id.save)
        setSupportActionBar(toolbar)
        imageExprience = findViewById(R.id.imageButton2)
        val fragment3 =Recycler()
        val galleryImage = registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { imageExprience!!.setImageURI(it) }
        imageExprience!!.setOnClickListener {
            galleryImage.launch("image/*")
        }
        datedebut = findViewById(R.id.text1)
        datefin = findViewById(R.id.textfin)

        datedebut!!.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .build()
            picker.show(supportFragmentManager, "materialDatePicker")
            picker.addOnPositiveButtonClickListener {
                picker.headerText
                datedebut!!.setText(picker.headerText)
            }
        }
        datefin!!.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .build()
            picker.show(supportFragmentManager, "materialDatePicker")
            picker.addOnPositiveButtonClickListener {
                picker.headerText
                datefin!!.setText(picker.headerText)
            }
        }
        save!!.setOnClickListener()
        {
            addToDataBase()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment3 ).commit()


            startActivity(Intent(this, Career::class.java).apply {

            });
        }
    }


    fun addToDataBase() {
        var exp: ExprienceEntity? = null

        when (counter) {
            0 -> exp = ExprienceEntity(
                1,
                image = imageExprience!!.id,
                address = address!!.editText!!.text.toString(),
                date_debut = date_debut!!.editText!!.text.toString(),
                date_fin = date_fin!!.editText!!.text.toString(),
                name = "harvard "
            )
        }
        counter++
        try {
            dataBase.ExpDao().insert(exp!!)
            champList.add(exp!!)
            recylcerChampionAdapter.ExprienceList = champList
            recylcerChampionAdapter.notifyDataSetChanged()
        } catch (ex: Exception) {
        }

    }

}

