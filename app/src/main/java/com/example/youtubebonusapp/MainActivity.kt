package com.example.youtubeapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubebonusapp.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
data class Videos(val vName:String,val vNum:String)

class MainActivity : AppCompatActivity() {

    lateinit var rv:RecyclerView
    lateinit var al: ArrayList<Videos>
    private lateinit var YoutubPlayer: YouTubePlayer
    lateinit var youTubePlayerView: YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkInternet()
        initilaize()
        YoutubView()
    }

    fun initilaize(){
        rv = findViewById(R.id.rv)
        youTubePlayerView = findViewById(R.id.youtube_player_view)
        al = arrayListOf(
            Videos("Numbers Game", "CiFyTc1SwPw"),
            Videos("Calculator", "ZbZFMDk69IA"),
            Videos("Guess the Phrase", "DU1qMhyKv8g"),
            Videos("Username and Password", "G_XYXuC8b9M"),
            Videos("GUI Username and Password", "sqJWyPhZkDw"),
            Videos("Country Capitals", "yBkRLhoVTmc"),
            Videos("Database Module", "E-Kb6FgMbVw"))
    }
    fun ViewAdapter(){
        rv.adapter = YouTubVidAdapter(al,YoutubPlayer)
        rv.layoutManager = GridLayoutManager(this,3)
    }
    fun YoutubView(){
        youTubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                YoutubPlayer = youTubePlayer
                YoutubPlayer.loadVideo(al[0].vNum,0f)
                rv.adapter?.notifyDataSetChanged()
                ViewAdapter()
            }
        })

    }

    fun checkInternet(){
        if(!connectedToInternet()){
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Internet Connection Not Found")
                .setPositiveButton("RETRY"){_, _ -> checkInternet()}
                .show()
        }
    }

    fun connectedToInternet(): Boolean{
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}


