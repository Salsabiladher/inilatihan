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
    private lateinit var rvFruit: RecyclerView
    private val list: ArrayList<Fruit> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        rvFruit = findViewById(R.id.rv_fruit)
        rvFruit.setHasFixedSize(true)

        list.addAll(FruitsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvFruit.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruit.adapter = listFruitAdapter

        listFruitAdapter.setOnItemClickCallback(object : ListFruitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fruit) {
                showSelectedFruit(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvFruit.layoutManager = GridLayoutManager(this, 2)
        val gridFruitAdapter = GridFruitAdapter(list)
        rvFruit.adapter = gridFruitAdapter

        gridFruitAdapter.setOnItemClickCallback(object : GridFruitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fruit) {
                showSelectedFruit(data)
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

    private fun showSelectedFruit(fruit: Fruit) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", fruit as Serializable)
        startActivity(intent)
    }
}
