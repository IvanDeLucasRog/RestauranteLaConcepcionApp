package com.platzi.conf.view.adapter


import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.platzi.conf.R
import com.platzi.conf.view.ui.fragments.MenuFragment
import com.platzi.conf.view.ui.fragments.ReservationFragment

/*class PeopleNumberSpinnerAdapter {

    var spinner : Spinner? = null

    val itemList = arrayListOf(
        "1 persona",
        "2 personas",
        "3 personas",
        "4 personas",
        "5 personas",
        "6 personas",
        "7 personas",
        "8 personas",
        "9 personas",
        "10 personas",
        "11 personas",
        "12 personas",
        "13 personas",
        "14 personas",
        "15 personas",
        "16 personas",
        "17 personas",
        "18 personas",
        "19 personas",
        "20+ personas"
    )

    fun setUpSpinner (context: Context){

        spinner?.findViewById<Spinner>(R.id.personsNumberSpinner)
        val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, itemList)
        spinner?.adapter = arrayAdapter

        spinner?.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Selecione el número de personas, por favor", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemselected : String = parent?.getItemAtPosition(position) as String
                Toast.makeText(context, " Mesa reservada para $itemselected ", Toast.LENGTH_LONG).show()
            }

        }
    }


    }


*/