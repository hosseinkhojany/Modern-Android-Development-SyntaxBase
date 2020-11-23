package com.example.modern_android_development.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.modern_android_development.custom_views.ClickableText

class Frag1 : Fragment(){
    override fun <I : Any?, O : Any?> prepareCall(
        contract: ActivityResultContract<I, O>,
        callback: ActivityResultCallback<O>
    ): ActivityResultLauncher<I> {
        TODO("Not yet implemented")
    }

    override fun <I : Any?, O : Any?> prepareCall(
        contract: ActivityResultContract<I, O>,
        registry: ActivityResultRegistry,
        callback: ActivityResultCallback<O>
    ): ActivityResultLauncher<I> {
        TODO("Not yet implemented")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(context = requireContext()).apply {
            setContent {
                MaterialTheme {
                    ClickableText{

                    }
                }
            }
        }
    }
}