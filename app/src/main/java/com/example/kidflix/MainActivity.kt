package com.example.kidflix

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidflix.adapter.AdaptadorVideo
import com.example.kidflix.model.Video
import com.example.kidflix.network.ApiCliente
import com.example.kidflix.network.ApiVideo
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    var videos: MutableList<Video> = mutableListOf()
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  videoAdapter: AdaptadorVideo

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_videos)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        showVideos();
    }

    fun showVideos() {
        val call = ApiCliente.getClient().create(ApiVideo::class.java).getVideos()
        call.enqueue(object : Callback<List<Video>> {
            override fun onResponse( call: retrofit2.Call<List<Video>>, response: Response<List<Video>> ) {
                if (response.isSuccessful) {
                    videos = response.body()!!.toMutableList() //CONVERTIR A LISTA MUTABLE
                    videoAdapter = AdaptadorVideo(videos, applicationContext)
                    recyclerView.adapter = videoAdapter
                }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show()
            }

        })
    }
}


