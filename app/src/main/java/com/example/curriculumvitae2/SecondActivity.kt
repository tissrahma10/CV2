package com.example.curriculumvitae2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI

import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.widget.Toolbar;

class SecondActivity : AppCompatActivity() {
    private var txtFullName: TextInputLayout? = null
    private var txtAge: TextInputLayout? = null
    private var txtEmail: TextInputLayout? = null
    private var btnNext: Button? = null
    private var error1: TextView? = null
    private var error2: TextView? = null
    private var error3: TextView? = null
    private var male: CheckBox? = null
    private var Female: CheckBox? = null
    private var image : ImageButton? = null
    private var image1 : ImageButton? = null
    private  var toolbar : Toolbar? = null
    private var selectedImage : Uri? = null
    private var iv: ImageView? = null
    private var uri: Uri? = null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        toolbar = findViewById(R.id.toolbar);
       setSupportActionBar( toolbar)
        txtFullName = findViewById(R.id.outlinedTextField)
        txtAge = findViewById(R.id.outlinedTextField2)
        txtEmail = findViewById(R.id.outlinedTextField1)
        btnNext = findViewById(R.id.button3)
        image = findViewById(R.id.imageButton4)
        image1 = findViewById(R.id.info)
        error1 = findViewById(R.id.textView2)
        error2 = findViewById(R.id.textView3)
        error3 = findViewById(R.id.textView5)
        val galleryImage = registerForActivityResult(ActivityResultContracts.GetContent()
        ) { image!!.setImageURI(it) }
        image!!.setOnClickListener{
             galleryImage.launch("image/*")
        }
        image1!!.setOnClickListener(){
            val intent = Intent(this, FourthActivity::class.java).apply {
                putExtra("FULLNAME", txtFullName?.editText?.text!!.toString())
                putExtra("EMAIL", txtEmail?.editText?.text!!.toString())
                putExtra("IMAGE", uri.toString())
            }
            startActivity(intent);
        }
        btnNext!!.setOnClickListener {
            if(galleryImage == null ){
                Toast.makeText(this, "Please select an image !", Toast.LENGTH_SHORT).show()
            }
            if (txtAge?.editText?.text!!.isEmpty()) {
                error2?.setText("must not be empty")
                txtAge?.error = "dsghbf"
                error3?.setText("")
                error1?.setText("")
            }
            if (txtFullName?.editText?.text!!.isEmpty()) {
                error1?.setText("must not be empty")
                txtFullName?.error = "dsghbf"
                error2?.setText("")
                error3?.setText("")
            }
            if (txtEmail?.editText?.text!!.isEmpty()) {
                error3?.setText("must not be empty")
                txtEmail?.error = "dsghbf"
                error1?.setText("")
                error2?.setText("")
            } else {
              val intent =   Intent(this, ThirdActivity::class.java).apply {
                    putExtra("FULLNAME", txtFullName?.editText?.text!!.toString())
                    putExtra("AGE", txtAge?.editText?.text!!.toString())
                    putExtra("EMAIL", txtEmail?.editText?.text!!.toString())
                }
                startActivity(intent)
            }
        }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null){
           selectedImage = data.getData();
            iv = findViewById(R.id.avatar)
            iv!!.setImageURI(selectedImage)

        }

    }*/

}





