package com.platzi.conf.view.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Menu
import com.platzi.conf.view.adapter.MenuAdapter
import com.platzi.conf.view.adapter.MenuListener
import com.platzi.conf.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment(), MenuListener { //herencia con implementación

    private lateinit var menuAdapter: MenuAdapter // acceso a firebase
    private lateinit var viewModel: MenuViewModel //acceso a view model

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        viewModel.refresh()

        menuAdapter = MenuAdapter(this)

        rvSchedule.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = menuAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.listMenu.observe(viewLifecycleOwner, Observer<List<Menu>> { schedule ->
            menuAdapter.updateData(schedule)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if(it != null)
                rlBaseSchedule.visibility = View.INVISIBLE
        })
    }

    override fun onMenuClicked(menu: Menu, position: Int) {
        val bundle = bundleOf("menu" to menu)
        findNavController().navigate(R.id.scheduleDetailFragmentDialog, bundle)
    }

}
