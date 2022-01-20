package com.example.sundmadnepal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sundmadnepal.adapter.HealthInfoAdapter
import com.example.sundmadnepal.data.DataSource
import com.example.sundmadnepal.model.HealthInfoPage

private const val TAG = "HealthInfoFragment"

class HealthInfoFragment : Fragment() {

    private val healthInfo = DataSource.healthInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val healthInfoAdapter =
            HealthInfoAdapter { healthInfoPage -> healthInfoOnClick(healthInfoPage) }
        healthInfoAdapter.submitList(healthInfo)

        val layoutManager = GridLayoutManager(activity, 2)

        val healthInfoView: RecyclerView = view.findViewById(R.id.health_info_cards)
        healthInfoView.adapter = healthInfoAdapter
        healthInfoView.layoutManager = layoutManager
        healthInfoView.setHasFixedSize(true)
    }

    private fun healthInfoOnClick(healthInfoPage: HealthInfoPage) {
        Log.d(TAG, "Health-info card pressed with id=${healthInfoPage.id}")

        val action =
            HealthInfoFragmentDirections.actionHealthInfoFragmentToHealthInfoPageFragment(pageId = healthInfoPage.id!!)
        findNavController().navigate(action)
    }
}
