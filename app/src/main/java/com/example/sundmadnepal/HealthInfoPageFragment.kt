package com.example.sundmadnepal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sundmadnepal.data.loadHealthInfo
import com.example.sundmadnepal.model.ElementType.IMAGE
import com.example.sundmadnepal.model.ElementType.PARAGRAPH
import com.example.sundmadnepal.model.HealthInfoPage

class HealthInfoPageFragment : Fragment() {

    private var pageId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { arguments ->
            pageId = arguments.getInt("pageId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_info_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linLayout: LinearLayout = view.findViewById(R.id.healthInfoLinLayout)

        val healthInfoPage: HealthInfoPage = loadHealthInfo().elementAt(pageId - 1)

        for (element in healthInfoPage.content) when (element.type) {
            PARAGRAPH -> {
                val textView = newTextView(element.contentRef, view.context)
                linLayout.addView(textView)
            }
            IMAGE -> {
                val imageView = newImageView(element.contentRef, view.context)
                linLayout.addView(imageView)
            }
        }
    }

    // Function to create a new textview
    private fun newTextView(id: Int, con: Context): TextView {
        val newView = TextView(con)

        newView.text = con.getString(id)
        newView.textSize = 18f

        // Add a bit of padding on the right, so the scrollbar does not cover any text
        newView.setPadding(0, 0, 10, 0)

        return newView
    }

    // Function to create a new imageview
    private fun newImageView(id: Int, con: Context): ImageView {
        val newView = ImageView(con)
        newView.setImageResource(id)

        // TODO: See if there is a way to not hardcode width
        newView.layoutParams = ViewGroup.LayoutParams(950, 700)

        return newView
    }
}
