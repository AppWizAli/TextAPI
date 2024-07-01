package com.hiskytechs.freemusicapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
recyclerView=findViewById(R.id.rvmusic)
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)



        val retrofitData=retrofitBuilder.getData("eminem")
        
        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {

                var result=response.body()?.data!!
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                recyclerView.adapter=MyAdapter(this@MainActivity,result)
                Toast.makeText(this@MainActivity, "Succcess", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Faiilure", Toast.LENGTH_SHORT).show()
            }
        })
        
        

    }
}