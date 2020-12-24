package com.esiea.android4a.presentation.list

import androidx.lifecycle.MutableLiveData
import com.esiea.android4a.Singletons
import com.esiea.android4a.domain.entity.Galaxie
import com.esiea.android4a.data.repository.RestGalaxiesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel {
    val status : MutableLiveData<ListeStatus> = MutableLiveData()
    val galaxieLiveData: MutableLiveData<Galaxie> = MutableLiveData()
    var galaxieList: List<Galaxie>? = null

    init{
        makeAPIcall()
    }

    private fun makeAPIcall() {
        val call = Singletons.galaxieAPI?.galaxieResponse
        call?.enqueue(object: Callback<RestGalaxiesResponse> {
            override fun onResponse(call: Call<RestGalaxiesResponse>, response: Response<RestGalaxiesResponse>) {
                if (response.isSuccessful && response.body() != null){
                    val galaxies = response.body()!!.galaxies
                    status.value = if(galaxies != null){
                        galaxieList = galaxies
                        ListeSuccess(galaxies)
                    }else{
                        ListeError
                    }
                }
                else{
                    status.value = ListeError
                }
            }
            override fun onFailure(call: Call<RestGalaxiesResponse>, t:Throwable) {
                status.value = ListeError
            }
        })
    }

    fun onItemClick(position: Int) {
        galaxieLiveData.value = galaxieList!![position]
    }
}