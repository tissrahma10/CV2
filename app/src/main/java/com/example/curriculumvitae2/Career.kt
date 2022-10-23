package com.example.curriculumvitae2


import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar

private var btnExprience : Button? = null
private  var toolbar : Toolbar? = null
class Career : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        btnExprience = findViewById(R.id.button2)
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar( toolbar)
        toolbar!!.inflateMenu(R.menu.items)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.items ,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.exprience ->
            startActivity(Intent(this, Exprience::class.java).apply {
            })
            R.id.education ->startActivity(Intent(this, Exprience::class.java).apply {
            })
            }
        return super.onOptionsItemSelected(item)
    }
        }



