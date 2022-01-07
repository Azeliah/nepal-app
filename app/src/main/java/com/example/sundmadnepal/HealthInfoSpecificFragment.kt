package com.example.sundmadnepal

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes


class HealthInfoSpecificFragment : Fragment() {

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

        // Example on how to create new views and add to linear layout
        val view1 = newTextView(resources.getString(R.string.zeroToSix1), view.context)
        val view2 = newTextView(resources.getString(R.string.zeroToSix2), view.context)

        linLayout.addView(view1)

        val imageView1 = newImageView(R.drawable.woman_breastfeeding, view.context)
        val imageView2 = newImageView(R.drawable.fried_chicken, view.context)

        linLayout.addView(imageView1)

        linLayout.addView(view2)

        linLayout.addView(imageView2)
    }

    // Function to create a new textview
    fun newTextView(str: String, con: Context): TextView {
        val newView = TextView(con)

        newView.text = str
        newView.textSize = 18f

        // Add a bit of padding on the right, so the scrollbar does not cover any text
        newView.setPadding(0,0,10,0)

        return newView
    }

    // Function to create a new imageview
    fun newImageView(id: Int, con: Context): ImageView {
        val newView = ImageView(con)
        newView.setImageResource(id)

        // TODO: See if there is a way to not hardcode width
        newView.layoutParams = ViewGroup.LayoutParams(950, 700)

        return newView
    }

}