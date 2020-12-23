package com.esiea.android4a.presentation.description

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.esiea.android4a.Constants
import com.esiea.android4a.R
import com.esiea.android4a.Singletons
import com.esiea.android4a.domain.entity.Galaxie
import kotlinx.android.synthetic.main.activity_description.*
import org.koin.android.ext.android.inject

class DescriptionActivity : AppCompatActivity() {

    private val descriptionViewModel : DescriptionViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val intent = getIntent()
        val galaxieJson = intent.getStringExtra(Constants.EXTRA_GALAXIE)
        val galaxie = Singletons.gson!!.fromJson(galaxieJson, Galaxie::class.java)
        descriptionViewModel.description(galaxie)

        descriptionViewModel.titreText.observe(this, Observer {
            value -> titre.text = value
        })

        descriptionViewModel.descriptionText.observe(this, Observer {
                value -> textDescription.text = value
        })

        buttonBackList.setOnClickListener {
            finish()
        }
    }
}