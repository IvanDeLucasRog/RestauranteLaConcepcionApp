package com.platzi.conf.view.ui.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast


import com.platzi.conf.R
import com.platzi.conf.view.adapter.PeopleNumberSpinnerAdapter

/**
 * A simple [Fragment] subclass.
 */
class ReservationFragment : Fragment(){

    private  val peopleNumberSpinnerAdapter = PeopleNumberSpinnerAdapter ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        peopleNumberSpinnerAdapter.setUpSpinner(view.context)

    }



}


