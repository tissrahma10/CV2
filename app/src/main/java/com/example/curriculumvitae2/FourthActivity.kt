package com.example.curriculumvitae2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import java.io.File

class FourthActivity : AppCompatActivity() {
    private var name : String? = ""
    private var email : String? = ""
    private var image : String? = null
    private var txtview1: TextView? = null
    private var txtview2: TextView? = null
    private var avatar: ImageView? = null
    private  var toolbar2 : Toolbar? = null
    private var ios: SeekBar? = null
    private var btnSkills: Button? = null
    private var btnHobbies: Button? = null
    private var btnLanguages: Button? = null
    private var btnCareer: Button? = null
    private var logout: ImageButton? = null

    private var music1: CheckBox? = null
    private var sport1: CheckBox? = null
    private var games1: CheckBox? = null


    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        toolbar2 = findViewById(R.id.toolbar2);
       logout = findViewById(R.id.logout)
        toolbar2!!.title = "Your Resume"
        logout!!.setOnClickListener{
            AlertDialog.Builder(this@FourthActivity)
                .setTitle("Logout")
                .setMessage("are you sure you want to logout ")
                .setCancelable(false)
                .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        getSharedPreferences("Login_pref", MODE_PRIVATE).edit().clear().apply()
                        finish()
                    }
                }).setNegativeButton("cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {


                    }
                })
                .show()
        }

        setSupportActionBar( toolbar2)
        name = intent.getStringExtra("FULLNAME");
        avatar  =  findViewById(R.id.avatar)
        image = intent.getStringExtra("IMAGE")
        avatar!!.setImageResource(R.drawable.screen_shot_2022_10_01_at_3_52_12_pm)
        email = intent.getStringExtra("EMAIL");
        txtview1 = findViewById(R.id.textView16)
        txtview2 = findViewById(R.id.textView17)
        txtview1!!.setText(name)
        txtview2!!.setText(email)
        btnSkills = findViewById(R.id.skills);
        btnHobbies = findViewById(R.id.hobbies);
        btnCareer = findViewById(R.id.button4);
        btnLanguages = findViewById(R.id.languages);
        btnCareer!!.setOnClickListener{
            val intent = Intent(this, Career::class.java).apply {


            }
            startActivity(intent)


        }
     val   music = intent.getBooleanExtra("MUSIC" , false);
    val sport =  intent.getBooleanExtra("SPORT" , false );
    val games =  intent.getBooleanExtra("GAMES" , false);
        val  arabic = intent.getBooleanExtra("ARABIC" , false);
        val frensh =  intent.getBooleanExtra("FRENSH" , false );
        val english =  intent.getBooleanExtra("ENGLISH" , false);

       val flutter1 =   intent.getIntExtra("FLUTTER" , 20);
     val  android1 =   intent.getIntExtra("ANDROID" , 20);
   val  ios1 =   intent.getIntExtra("IOS", 20)

val fragment2 = BlankFragment2()
        btnHobbies!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putBoolean("music", music)
            bundle.putBoolean("sport", sport)
            bundle.putBoolean("games", games)
            fragment2.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment2).commit()
        }
        val fragment3 = BlankFragment3()
        btnLanguages!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putBoolean("arabic", arabic)
            bundle.putBoolean("english", english)
            bundle.putBoolean("frensh", frensh)
            fragment3.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment3).commit()
        }
        val fragment1 = BlankFragment()
        btnSkills!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putInt("flutter", flutter1!!)
            bundle.putInt("android", android1!!)
            bundle.putInt("ios", ios1!!)
            fragment1.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment1).commit()
        }
    }
}


