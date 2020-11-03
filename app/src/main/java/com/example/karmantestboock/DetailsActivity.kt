package com.example.karmantestboock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.karmantestboock.databinding.ActivityDetailsBinding
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {

    lateinit var bind: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        bind = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val cover = Gson().fromJson(intent.getStringExtra("cover"), Cover::class.java)
        Glide.with(this)
            .load(cover.image)
            .into(bind.imageView)
        bind.apply {
            title.text = cover.title
            author.text = cover.author
            desc.text = cover.description
        }
    }
}