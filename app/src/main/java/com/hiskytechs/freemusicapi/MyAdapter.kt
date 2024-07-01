package com.hiskytechs.freemusicapi

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context, var listData: List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // ViewHolder class to hold the views
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageButton: ImageButton = itemView.findViewById(R.id.imageButton)
        val imageButton2: ImageButton = itemView.findViewById(R.id.imageButton2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the item layout and create a ViewHolder instance
        val view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind data to the views in each item
        val currentItem = listData[position]
        holder.textView.text=currentItem.title
        Picasso.get().load(currentItem.album.cover).into(holder.imageView)

        val mediaplayer=MediaPlayer.create(context,currentItem.preview.toUri())

        holder.imageButton.setOnClickListener()
        {
            Toast.makeText(context, "click ho gya hai ", Toast.LENGTH_SHORT).show()
            mediaplayer.start()
        }
        holder.imageButton2.setOnClickListener()
        {
            mediaplayer.pause()
        }

    }

    override fun getItemCount(): Int {
        // Return the size of the data list
        return listData.size
    }
}
