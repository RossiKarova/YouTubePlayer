package com.example.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

//        val btnPlayVideo = findViewById<ConstraintLayout>(R.id.activity_standalone)
//        val btnPlayList = findViewById<ConstraintLayout>(R.id.activity_standalone)


        btnPlayVideo.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)

//        btnPlayVideo.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })

//        btPlayVideo.setOnClockListener(View.OnClickListener {v->
//            TODO("Not yet implemented")
//        })

//        val listener = View.OnClickListener { v ->
//            TODO("Not yet implemented")
//        }
//        btnPlayVideo.setOnClickListener(listener)
//        btnPlayList.setOnClickListener(listener)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
                    this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID)
            R.id.btnPlayList -> YouTubeStandalonePlayer.createPlaylistIntent(
                    this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST)
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}