package com.esiea.android4a.presentation.list

import com.esiea.android4a.domain.entity.Galaxie

sealed class ListeStatus

data class ListeSuccess(val galaxies : List<Galaxie>) : ListeStatus()
object ListeError : ListeStatus()