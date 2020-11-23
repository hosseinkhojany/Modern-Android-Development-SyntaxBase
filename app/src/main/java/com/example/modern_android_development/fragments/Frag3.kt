package com.example.modern_android_development.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.modern_android_development.R
import com.example.modern_android_development.custom_views.ClickableText

class Frag3 : Fragment(){

    var str: String = "Null"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        str = arguments?.getString("str").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(context = requireContext()).apply {
            setContent {
                MaterialTheme {
                    Column() {
                        ClickableText{
                            findNavController().navigate(
                                R.id.action_frag3_to_frag1
                            )
                        }
                        Text(text = "Fragment 3 + Bundle $str")
                    }
                }
            }
        }
    }
}