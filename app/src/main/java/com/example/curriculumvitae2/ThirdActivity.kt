package com.example.curriculumvitae2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputLayout


const val IS_REMEMBRED = "IS_REMEMBRED"
class ThirdActivity : AppCompatActivity() {
    private var arabic: CheckBox? = null
    private var frensh: CheckBox? = null
    private var english: CheckBox? = null
    private var music: CheckBox? = null
    private var sport: CheckBox? = null
    private var games: CheckBox? = null
    private var btnNext: Button? = null
    private var btnLogin : CheckBox? = null
    private var error1: TextView? = null
    private var error2: TextView? = null
    private var ios: SeekBar? = null
    private var flutter: SeekBar? = null
    private var androids: SeekBar? = null
    private var name: String? = ""
    private var age: String? = ""
    private var email: String? = ""
    private var toolbar: Toolbar? = null
    private var image: ImageButton? = null


    private var txtFullName: TextInputLayout? = null
    private var image1: ImageButton? = null
    private var txtEmail: TextInputLayout? = null
    lateinit var mSharedPref: SharedPreferences
    private var langage = ""
    private var hobbies = ""


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        mSharedPref = getSharedPreferences("Login_pref", MODE_PRIVATE);
        btnNext = findViewById(R.id.button)
        arabic = findViewById(R.id.arabic)
        txtFullName = findViewById(R.id.outlinedTextField)
        txtEmail = findViewById(R.id.outlinedTextField1)
        btnLogin=findViewById(R.id.checkBox7)
        frensh = findViewById(R.id.frensh)
        english = findViewById(R.id.english)
        music = findViewById(R.id.music)
        sport = findViewById(R.id.sport)
        games = findViewById(R.id.games)
        image1 = findViewById(R.id.info)

        error1 = findViewById(R.id.textView11)
        error2 = findViewById(R.id.textView12)
        flutter = findViewById(R.id.seekBar3)
        androids = findViewById(R.id.seekBar)
        ios = findViewById(R.id.seekBar2)
        image = findViewById(R.id.info)

        name = intent.getStringExtra("FULLNAME").toString();
        age = intent.getStringExtra("AGE").toString();
        email = intent.getStringExtra("EMAIL").toString();
        toolbar = findViewById(R.id.toolbar);
        if (mSharedPref.getBoolean(IS_REMEMBRED, false)){

        }

        btnNext!!.setOnClickListener {
            if (validate()) {

                if (btnLogin!!.isChecked) {

                    //TODO 4 "Edit the SharedPreferences by putting all the data"
                    mSharedPref.edit().apply {
                        putBoolean(IS_REMEMBRED, true)
                        putString("fullname", name)
                        putString("age", age)
                        putString("email", email)
                    }.apply()
                    navigate()
                } else {
                    mSharedPref.edit().clear().apply()
                }
                navigate()
            }

        }

    }
    private fun validate(): Boolean {


        if (!arabic?.isChecked!! && !frensh?.isChecked!! && !english?.isChecked!!){
            error1?.setText("you have to check at least one item ")
            return false
        }

        if (!music?.isChecked!! && !games?.isChecked!! && !sport?.isChecked!!){
            error2?.setText("you have to check at least one item ")
            return false
        }

        return true
    }
fun navigate (){
    if (!arabic?.isChecked!! && !frensh?.isChecked!! && !english?.isChecked!!) {
        error1?.setText("you have to check at least one item ")
    }
    if (!music?.isChecked!! && !games?.isChecked!! && !sport?.isChecked!!) {
        error2?.setText("you have to check at least one item ")
    } else {

        val intent = Intent(this, FourthActivity::class.java).apply {
            putExtra("FULLNAME", name)
            putExtra("AGE", age)
            putExtra("EMAIL", email)
            putExtra("LANGAGE", langage)
            putExtra("MUSIC", music!!.isChecked)
            putExtra("ARABIC", arabic!!.isChecked)
            putExtra("ENGLISH", english!!.isChecked)
            putExtra("FRENSH", frensh!!.isChecked)
            putExtra("SPORT", sport!!.isChecked)
            putExtra("GAMES", games!!.isChecked)
            putExtra("FLUTTER", flutter?.progress)
            putExtra("ANDROID", androids?.progress)
            putExtra("IOS", ios?.progress)

        }
        startActivity(intent)
    }
        setSupportActionBar(toolbar)
        image1!!.setOnClickListener() {
            val intent = Intent(this, FourthActivity::class.java).apply {

                putExtra("MUSIC", music!!.isChecked)
                putExtra("SPORTS",sport!!.isChecked)
                putExtra("GAMES", games!!.isChecked)
                putExtra("FLUTTER", flutter?.progress)
                putExtra("ANDROID", androids?.progress)
                putExtra("IOS", ios?.progress)


            }
            startActivity(intent)


        }

            image!!.setOnClickListener {
                val intent = Intent(this, FourthActivity::class.java).apply {
//                putExtra("FULLNAME", txtFullName?.editText?.text!!.toString())
                    //       putExtra("EMAIL", txtEmail?.editText?.text!!.toString())

                }
                startActivity(intent)


            }
            if (arabic?.isChecked == true) {
                langage == "arabic "
            }
            if (frensh?.isChecked == true) {
                langage == "frensh "
            }
            if (english?.isChecked == true) {
                langage == "english "
            }
            if (sport?.isChecked == true) {
                hobbies == "sport "
            }
            if (games?.isChecked == true) {
                hobbies == "games"
            }
            if (music?.isChecked == true) {
                hobbies == "music "
            }



        }
    }
