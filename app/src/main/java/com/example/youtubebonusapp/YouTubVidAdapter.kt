package com.example.youtubeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubebonusapp.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.viditemview.view.*

class YouTubVidAdapter(val Vid:ArrayList<Videos>,val player: YouTubePlayer):RecyclerView.Adapter<YouTubVidAdapter.VH>(){
    class VH(VidListView:View):RecyclerView.ViewHolder(VidListView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.viditemview,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val Items = Vid[position]
        val name = Items.vName
        val num = Items.vNum
        holder.itemView.apply {
            button.text = name
            button.setOnClickListener {
                player.loadVideo(num, 0f)
            }

        }

    }
    override fun getItemCount() = Vid.size
}

//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.recyclerview.widget.RecyclerView
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
//import kotlinx.android.synthetic.main.viditemview.view.*
//import kotlinx.android.synthetic.main.viditemview.view.*
//
//class VideoAdapter(
//    private val videoList: Array<Array<String>>,
//    private val player: YouTubePlayer): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){
//    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val button: Button = itemView.button
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(
//            R.layout.viditemview,
//            parent,
//            false
//        )
//        return VideoViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
//        val currentTitle = videoList[position][0]
//        val currentLink = videoList[position][1]
//        holder.button.text = currentTitle
//        holder.button.setOnClickListener {
//            player.loadVideo(currentLink, 0f)
//        }
//    }
//
//    override fun getItemCount() = videoList.size
//}