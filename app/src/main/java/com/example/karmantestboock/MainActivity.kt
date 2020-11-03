package com.example.karmantestboock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karmantestboock.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        supportActionBar?.hide()

        API.api.getCovers().enqueue(object : Callback<List<Cover>> {
            override fun onResponse(call: Call<List<Cover>>, response: Response<List<Cover>>) {
                bind.list.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter(this@MainActivity, response.body() ?: listOf())
                }
            }

            override fun onFailure(call: Call<List<Cover>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Internet error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}