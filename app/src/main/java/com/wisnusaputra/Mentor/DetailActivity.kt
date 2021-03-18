package com.wisnusaputra.fruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(findViewById(R.id.toolbar_detail))
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        val mentor = intent.extras.get("data") as Mentor

        val layanan: TextView = findViewById(R.id.layanan)
        val detail: TextView = findViewById(R.id.detail)
        val jenis: TextView = findViewById(R.id.jenis)
        val img: ImageView = findViewById(R.id.img_detail)

        detail.text = mentor.detail
        jenis.text = mentor.jenis
        layanan.text = mentor.layanan
        img.setImageResource(mentor.photo)
    }
}
