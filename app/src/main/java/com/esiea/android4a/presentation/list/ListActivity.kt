package com.esiea.android4a.presentation.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.esiea.android4a.R
import com.esiea.android4a.domain.entity.Galaxie
import com.esiea.android4a.presentation.description.DescriptionActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer
import com.esiea.android4a.Constants
import com.esiea.android4a.Singletons

class ListActivity  : AppCompatActivity(), ListAdapter.OnItemClickListener {

    private val listViewModel : ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listViewModel.status.observe(this, Observer {
            when(it){
                is ListeSuccess ->{
                    showList(it.galaxies)
                }
                ListeError -> showErreur()
            }
        })

    }

    private fun showList(galaxieList:List<Galaxie>){
        recycler_view.adapter = galaxieList.let { ListAdapter(it, this) }
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        listViewModel.onItemClick(position)
        listViewModel.galaxieLiveData.observe(this, Observer {
            value -> run {
                val intent = Intent(this, DescriptionActivity::class.java)
                intent.putExtra(Constants.EXTRA_GALAXIE, Singletons.gson!!.toJson(value))
                startActivity(intent)
            }
        })

    }

    fun showErreur() {
        Toast.makeText(this, "Connection failure", Toast.LENGTH_SHORT).show()
    }
}