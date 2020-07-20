package com.platzi.conf.view.ui.fragments


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.platzi.conf.R
import com.platzi.conf.model.Ubication
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_menu_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_ubication_detail_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class UbicationDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarUbication.navigationIcon =
            ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarUbication.setTitleTextColor(Color.BLACK)
        toolbarUbication.setNavigationOnClickListener {
            dismiss()
        }


        val ubication = Ubication()
        toolbarUbication.title = ubication.name
        tvDetailNombreLugar.text = ubication.name
        tvUbicationDirection.text = ubication.address
        tvUbicationTel.text = ubication.phone
        tvUbicationUrl.text = ubication.website
        Picasso.get().load(ubication.photo).into(iv_UbicationDetail)

        llTelUbication.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${ubication.phone}")
            }
            startActivity(intent)
        }
        llurlUbication.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(ubication.website)
            startActivity(intent)
        }



    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
