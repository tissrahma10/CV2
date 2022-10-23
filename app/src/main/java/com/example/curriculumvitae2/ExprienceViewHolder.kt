package com.example.curriculumvitae2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExprienceViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image : ImageView = itemView.findViewById<ImageView>(R.id.imageView7)
        val address : TextView = itemView.findViewById<TextView>(R.id.textView21)
        val nameexp : TextView = itemView.findViewById<TextView>(R.id.textView20)
        val btnDelete : ImageView = itemView.findViewById(R.id.imageButton)

}