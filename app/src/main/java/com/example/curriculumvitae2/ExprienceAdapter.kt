package com.example.curriculumvitae2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExprienceAdapter (var ExprienceList: MutableList<ExprienceEntity>) : RecyclerView.Adapter<ExprienceViewHolder>() {





        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExprienceViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_item, parent, false)

            return ExprienceViewHolder(view)
        }

        override fun onBindViewHolder(holder: ExprienceViewHolder, position: Int) {

            val nameExp= ExprienceList[position].name

            val addressexp = ExprienceList[position].address

            holder.image.setImageResource(ExprienceList[position].image)
            holder.nameexp.text = nameExp
            holder.address.text = addressexp

       /*     holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                intent.apply {
                    putExtra(PICTURE, championsList[position].champPic)
                    putExtra(NAME, name)
                    putExtra(ROLE, role)
                }
                holder.itemView.context.startActivity(intent)
            }*/

            holder.btnDelete.setOnClickListener {
                //TODO 13 "Delete a champion from the database and refresh the recyclerView"
                AppDataBase.getDatabase(holder.itemView.context).ExpDao().delete(ExprienceList[position])
                ExprienceList.removeAt(position)
                notifyDataSetChanged()
            }

        }

        override fun getItemCount() = ExprienceList.size


}