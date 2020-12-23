package com.esiea.android4a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esiea.android4a.R
import com.esiea.android4a.domain.entity.Galaxie
import kotlinx.android.synthetic.main.row_layout.view.*

class ListAdapter(
    private val galaxies:List<Galaxie>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imageView: ImageView = itemView.icon
        val textView1: TextView = itemView.firstLine
        val textView2: TextView = itemView.secondLine

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = galaxies[position]
        holder.textView1.text = currentItem.name
        holder.textView2.text = "Constellation: " + currentItem.constellation
        //Picasso.get().load(galaxie.getUrl()).fit().into(holder.icon)
        /*holder.itemView.setOnClickListener(object:View.OnClickListener() {
            fun onClick(v:View) {
                listener.onItemClick(galaxie)
            }
        }*/
    }

    override fun getItemCount() = galaxies.size
}