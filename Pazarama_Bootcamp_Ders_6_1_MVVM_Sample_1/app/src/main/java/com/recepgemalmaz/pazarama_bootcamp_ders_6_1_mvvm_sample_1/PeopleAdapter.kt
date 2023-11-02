package com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.models.Person
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.viewModels.PersonVM

class PeopleAdapter(context: Context, vm: PersonVM) : BaseAdapter() {

    private var context: Context? = null
    private var vm: PersonVM? = null
    private var data: MutableList<Person>? = null

    init {
        this.context = context
        this.vm = vm
        this.data = vm.People
    }

    override fun getCount(): Int {
        return data!!.size
    }

    override fun getItem(p0: Int): Any {
        return this.data!![p0]
    }

    override fun getItemId(p0: Int): Long {
        return this.data!![p0].id!!.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var p = getItem(p0) as Person
        var lay = LayoutInflater.from(context).inflate(R.layout.person_displayer, null, false) as LinearLayout
        var txt1 =  lay.findViewById<TextView>(R.id.txtPersonName)
        var txt2 =  lay.findViewById<TextView>(R.id.txtPersonPhone)
        var txt3 = lay.findViewById<TextView>(R.id.txtPersonID)

        //Data Binding

        txt1.text = p.name
        txt2.text = p.phone
        txt3.text = p.id

        return lay

    }
}