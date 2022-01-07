package com.example.sundmadnepal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.card.MaterialCardView

private const val TAG = "HealthInfoFragment"

class HealthInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // FIXME: Use RecyclerView+database or view binding to remove this ugly shit

        val generalInfoView = view.findViewById<MaterialCardView>(R.id.general)
        generalInfoView.setOnClickListener { healthInfoOnClick(generalInfoView) }

        val pregnantInfoView = view.findViewById<MaterialCardView>(R.id.pregnant)
        pregnantInfoView.setOnClickListener { healthInfoOnClick(pregnantInfoView) }

        val zeroToSixInfoView = view.findViewById<MaterialCardView>(R.id.zero_to_six_months)
        zeroToSixInfoView.setOnClickListener { healthInfoOnClick(zeroToSixInfoView) }

        val sixToNineInfoView = view.findViewById<MaterialCardView>(R.id.six_to_nine_months)
        sixToNineInfoView.setOnClickListener { healthInfoOnClick(sixToNineInfoView) }

        val nineToTwelveInfoView = view.findViewById<MaterialCardView>(R.id.nine_to_twelve_months)
        nineToTwelveInfoView.setOnClickListener { healthInfoOnClick(nineToTwelveInfoView) }

        val twelveToTwentyFourInfoView =
            view.findViewById<MaterialCardView>(R.id.twelve_to_twenty_four_months)
        twelveToTwentyFourInfoView.setOnClickListener { healthInfoOnClick(twelveToTwentyFourInfoView) }
    }

    private fun healthInfoOnClick(view: View) {
        /*
         * NOTE: If health-info gets implemented with RecyclerView+database, this function should be
         *       passed a data-model like in RecipesFragment, instead of a view.
         *       In any case, I'm sure there's a better way of identifying which card was pressed
         *       than passing the view.
         */

        // TODO: Implement navigating to the health-info activity/fragment
        Log.d(TAG, "Health-info card pressed with id=${view.id}")
    }
}