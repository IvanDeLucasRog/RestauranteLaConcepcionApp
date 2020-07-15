package com.platzi.conf.view.ui.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Menu
import com.platzi.conf.model.Plates
import com.platzi.conf.view.adapter.MenuAdapter
import com.platzi.conf.view.adapter.MenuDialogAdapter
import com.platzi.conf.viewmodel.MenuViewModel
import com.platzi.conf.viewmodel.PlateViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu_detail_dialog.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class MenuDetailDialogFragment : DialogFragment() {

    private lateinit var platesAdapter: MenuDialogAdapter // acceso a firebase
    private lateinit var viewModel: PlateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarConference.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarConference.setTitleTextColor(Color.WHITE)
        toolbarConference.setNavigationOnClickListener {
            dismiss()
        }
        val menu = arguments?.getSerializable("menu") as Menu
        toolbarConference.title = menu.title
        tvDetailMenuTitulo.text = menu.title
        tvDetailConferenceTag.text = menu.tag
        Picasso.get().load(menu.imageDetail).into(ivDetailMenu)

        //Configuración del Recycler View

        viewModel = ViewModelProviders.of(this).get(PlateViewModel::class.java)
        viewModel.refresh()

        platesAdapter = MenuDialogAdapter()

        rvDetailMenu.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = platesAdapter
        }
        viewModel.listPlates.observe(viewLifecycleOwner, Observer<List<Plates>> { platos ->
            platesAdapter.updateData(platos)
        })
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }


    }



