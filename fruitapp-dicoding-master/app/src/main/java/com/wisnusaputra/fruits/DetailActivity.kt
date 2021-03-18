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


        val fruit = intent.extras.get("data") as Fruit

        val manfaat: TextView = findViewById(R.id.manfaat)
        val detail: TextView = findViewById(R.id.detail)
        val title: TextView = findViewById(R.id.title)
        val img: ImageView = findViewById(R.id.img_detail)

        detail.text = fruit.detail
        title.text = fruit.name
        manfaat.text = fruit.manfaat
        img.setImageResource(fruit.photo)
    }
}
