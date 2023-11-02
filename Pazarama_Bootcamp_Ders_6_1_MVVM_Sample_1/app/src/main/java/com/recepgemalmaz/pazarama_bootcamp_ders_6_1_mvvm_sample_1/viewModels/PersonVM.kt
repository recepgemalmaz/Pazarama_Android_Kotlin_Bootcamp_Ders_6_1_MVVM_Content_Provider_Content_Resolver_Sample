package com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.viewModels


import androidx.lifecycle.ViewModel
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.RehberRepository
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.models.Person

class PersonVM (repository: RehberRepository): ViewModel() {
    private var repository: RehberRepository? = null
    init {
        this.repository = repository
    }

    val People: MutableList<Person>
        get() = repository!!.Get()

}