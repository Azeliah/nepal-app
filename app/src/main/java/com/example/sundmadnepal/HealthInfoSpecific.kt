package com.example.sundmadnepal

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes


class HealthInfoSpecific : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_info_specific, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val linLayout: LinearLayout = view.findViewById(R.id.healthInfoLinLayout)

        val view1 = newTextView(resources.getString(R.string.zeroToSix1), view.context)
        val view2 = newTextView(resources.getString(R.string.zeroToSix2), view.context)

        linLayout.addView(view1)

        val imageView1 = newImageView(R.drawable.woman_breastfeeding, view.context)

        linLayout.addView(imageView1)

        linLayout.addView(view2)

    }

    // Function to create a new textview
    fun newTextView(str: String, con: Context): TextView {
        val newView = TextView(con)
        newView.text = str
        return newView
    }

    // Function to create a new imageview
    fun newImageView(id: Int, con: Context): ImageView {
        val newView = ImageView(con)
        newView.setImageResource(id)
        return newView
    }

}