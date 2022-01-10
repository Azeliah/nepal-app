package com.example.sundmadnepal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sundmadnepal.data.loadHealthInfo
import com.example.sundmadnepal.model.HealthInfoPage
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

        val healthInfoPages = loadHealthInfo(requireContext())

        val generalInfoView: MaterialCardView = view.findViewById(R.id.general)
        generalInfoView.setOnClickListener { healthInfoOnClick(healthInfoPages.elementAt(0)) }

        val pregnantInfoView: MaterialCardView = view.findViewById(R.id.pregnant)
        pregnantInfoView.setOnClickListener { healthInfoOnClick(healthInfoPages.elementAt(0)) }

        val zeroToSixInfoView: MaterialCardView = view.findViewById(R.id.zero_to_six_months)
        zeroToSixInfoView.setOnClickListener { healthInfoOnClick(healthInfoPages.elementAt(0)) }

        val sixToNineInfoView: MaterialCardView = view.findViewById(R.id.six_to_nine_months)
        sixToNineInfoView.setOnClickListener { healthInfoOnClick(healthInfoPages.elementAt(0)) }

        val nineToTwelveInfoView: MaterialCardView = view.findViewById(R.id.nine_to_twelve_months)
        nineToTwelveInfoView.setOnClickListener { healthInfoOnClick(healthInfoPages.elementAt(0)) }

        val twelveToTwentyFourInfoView: MaterialCardView =
            view.findViewById(R.id.twelve_to_twenty_four_months)
        twelveToTwentyFourInfoView.setOnClickListener {
            healthInfoOnClick(healthInfoPages.elementAt(0))
        }
    }

    private fun healthInfoOnClick(healthInfoPage: HealthInfoPage) {
        Log.d(TAG, "Health-info card pressed with id=${healthInfoPage.id}")

        val action =
            HealthInfoFragmentDirections.actionHealthInfoFragmentToHealthInfoSpecific(pageId = healthInfoPage.id)
        findNavController().navigate(action)
    }
}
