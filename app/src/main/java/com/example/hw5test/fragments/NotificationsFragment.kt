package com.example.hw5test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw5test.R
import com.example.hw5test.extensions.navigate
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null && requireArguments().containsKey("count")) {
            count = NotificationsFragmentArgs
                .fromBundle(requireArguments()).count
        }
        text_notifications.text = (0 .. count).joinToString(sep)
        button_notifications.setOnClickListener {
            navigate(NotificationsFragmentDirections.actionNotificationsFragmentSelf(count + 1))
        }
    }
}