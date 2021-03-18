package com.wisnusaputra.fruits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var rvMentor: RecyclerView
    private val list: ArrayList<Mentor> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        rvMentor = findViewById(R.id.rv_mentor)
        rvMentor.setHasFixedSize(true)

        list.addAll(MentorData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvMentor.layoutManager = LinearLayoutManager(this)
        val listMentorAdapter = ListMentorAdapter(list)
        rvMentor.adapter = listMentorAdapter

        listMentorAdapter.setOnItemClickCallback(object : ListMentorAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mentor) {
                showSelectedMentor (data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvMentor.layoutManager = GridLayoutManager(this, 2)
        val gridMentorAdapter = GridMentorAdapter(list)
        rvMentor.adapter = gridMentorAdapter

        gridMentorAdapter.setOnItemClickCallback(object : GridMentorAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mentor) {
                showSelectedMentor (data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        setMode(item!!.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectMode: Int){
        when(selectMode){
            R.id.about ->{
                gotoAbout()
            }
            R.id.show_grid ->{
                showRecyclerGrid()
            }
            R.id.show_list -> {
                showRecyclerList()
            }
        }
    }

    private fun gotoAbout(){
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun showSelectedFruit(fruit: Mentor) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", fruit as Serializable)
        startActivity(intent)
    }
}
