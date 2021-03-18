package com.wisnusaputra.fruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setSupportActionBar(findViewById(R.id.toolbar_about))
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }
}
