package com.example.hw5test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw5test.R
import com.example.hw5test.extensions.navigate
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*

class DashboardFragment : Fragment() {
    private var count = 0
    private val sep = "->"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null && requireArguments().containsKey("count")) {
            count = DashboardFragmentArgs
                .fromBundle(requireArguments()).count
        }
        text_dashboard.text = (0 .. count).joinToString(sep)
        button_dashboard.setOnClickListener {
            navigate(DashboardFragmentDirections.actionDashboardFragmentSelf(count + 1))
        }
    }
}