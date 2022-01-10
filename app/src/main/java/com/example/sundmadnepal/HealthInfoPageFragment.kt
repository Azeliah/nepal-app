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
import com.example.sundmadnepal.data.loadHealthInfo
import com.example.sundmadnepal.model.ElementType.*
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
        return inflater.inflate(R.layout.fragment_health_info_specific, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linLayout: LinearLayout = view.findViewById(R.id.healthInfoLinLayout)

        val healthInfoPage: HealthInfoPage = loadHealthInfo(requireContext()).elementAt(pageId - 1)

        for (element in healthInfoPage.content) when (element.type) {
            PARAGRAPH -> {
                assert(element.content is String)
                val textView = newTextView(element.content as String, view.context)
                linLayout.addView(textView)
            }
            IMAGE -> {
                assert(element.content is Int)
                val imageView = newImageView(element.content as Int, view.context)
                linLayout.addView(imageView)
            }
        }
    }

    // Function to create a new textview
    private fun newTextView(str: String, con: Context): TextView {
        val newView = TextView(con)

        newView.text = str
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
