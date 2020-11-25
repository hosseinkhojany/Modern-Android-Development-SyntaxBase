package com.example.modern_android_development.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.modern_android_development.NavHostActivityWithXml
import com.example.modern_android_development.R
import com.example.modern_android_development.custom_views.AppBarConfig

class LoginActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*Disable Drawer*/
//        (activity as? NavHostActivityWithXml)?.drawerDisable(true)

        return ComposeView(context = requireContext()).apply {
            setContent {
                Column {

                    AppBarConfig(activity = activity , title = {} , actions = {})

                    LoginContent(activity) {
                        /* navigate to fragment one */
                        findNavController().navigate(R.id.action_loginFragment_to_frag1)
                    }
                }
            }
        }
    }
}