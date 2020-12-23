package com.esiea.android4a.presentation.description

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esiea.android4a.domain.entity.Galaxie

class DescriptionViewModel : ViewModel(){
    val titreText : MutableLiveData<String> = MutableLiveData()
    val descriptionText : MutableLiveData<String> = MutableLiveData()

    fun description(galaxie: Galaxie){//titre: String?, description: String?) {
        titreText.value = galaxie.name
        if(galaxie.description == null || galaxie.description == ""){
            descriptionText.value = "pas de description disponible pour cette galaxie"
        }else{
            descriptionText.value = galaxie.description
        }
    }
}