package com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.models.Person

class RehberRepository(context: Context) {

    private lateinit var context: Context

    init {
        this.context = context
    }

    fun Get(): MutableList<Person>
    {
        var lst = mutableListOf<Person>()
        var proxy = context.contentResolver
        var uri = ContactsContract.Contacts.CONTENT_URI

        var cols = arrayOf<String>(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME
        )

        var cursor = proxy.query(
            uri,
            cols,
            "",
            null,
            ""
        )!!

        while (cursor.moveToNext())
        {
            lst.add(
                Person(
                    cursor.getString(0),
                    cursor.getString(1),
                    "(xxx) xxx.xx.xx"
                )
            )
        }
        return lst
    }

}