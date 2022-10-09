package com.example.curriculumvitae2

import android.annotation.SuppressLint
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
    private  var toolbar : Toolbar? = null
    private var ios: SeekBar? = null
    private var btnSkills: Button? = null
    private var btnHobbies: Button? = null
    private var btnLanguages: Button? = null
    private var music: Boolean = true
    private var sport: Boolean = true
    private var games: Boolean = true
    private var music1: CheckBox? = null
    private var sport1: CheckBox? = null
    private var games1: CheckBox? = null
    private var ios1: Int? = null
    private var flutter1: Int? = null
    private var android1 : Int? = null
    private var progressF: Int? = null
    private var progressA: Int? = null
    private var progressI: Int? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar)
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
        btnLanguages = findViewById(R.id.languages);
        music = intent.getBooleanExtra("MUSIC" , true);
        sport =  intent.getBooleanExtra("SPORTS" , true );
        games =  intent.getBooleanExtra("GAMES" , true );
        music1 = findViewById(R.id.checkBox)
        sport1 = findViewById(R.id.checkBox2)
        games1 = findViewById(R.id.checkBox3)
        flutter1 =   intent.getIntExtra("FLUTTER" , 20);
        android1 =   intent.getIntExtra("ANDROID" , 20);
        ios1 =   intent.getIntExtra("IOS" , 20);


val fragment2 = BlankFragment2()
        btnHobbies!!.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment2).commit()
            val mBundle = Bundle()
            mBundle.putBoolean("MUSIC1",music )
            mBundle.putBoolean("SPORTS1",sport )
            mBundle.putBoolean("GAMES1",games )
            BlankFragment2().arguments = mBundle

        }

        val fragment3 = BlankFragment3()
        btnLanguages!!.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment3).commit()
        }
        val fragment1 = BlankFragment()
        btnSkills!!.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment1).commit()
            val mBundle = Bundle()
            mBundle.putInt("ios",ios1!! )
            mBundle.putInt("andoid",android1!! )
            mBundle.putInt("flutter",flutter1!! )
            BlankFragment2().arguments = mBundle
        }
    }
}


