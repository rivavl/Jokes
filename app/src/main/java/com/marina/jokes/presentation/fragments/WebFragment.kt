package com.marina.jokes.presentation.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.marina.jokes.R
import com.marina.jokes.databinding.FragmentJokesListBinding
import com.marina.jokes.databinding.FragmentWebBinding

class WebFragment : Fragment(R.layout.fragment_web) {

    private lateinit var binding: FragmentWebBinding

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWebBinding.bind(view)
        webViewSetup()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            } else if (binding.webView.url != "https://api.chucknorris.io") {
                binding.webView.loadUrl("https://api.chucknorris.io")
            } else {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun saveUserUrl(url: String) {
        val sharedPrefs = activity?.getSharedPreferences(SH_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPrefs?.edit()
        editor?.apply {
            putString(USER_URL, url)
            apply()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //сохраняем последний юрл перед выходом
        binding.webView.url?.let { saveUserUrl(it) }
    }

    private fun getUserUrl(): String {
        val sharedPrefs = activity?.getSharedPreferences(SH_PREFS, Context.MODE_PRIVATE)
        return sharedPrefs?.getString(USER_URL, "").toString()
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        binding.webView.webViewClient = WebViewClient()
        val userUrl = getUserUrl()
        binding.webView.apply {
            if (userUrl.isNotEmpty()) {
                loadUrl(userUrl)
            } else {
                loadUrl("https://api.chucknorris.io")
            }
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    companion object {
        const val SH_PREFS = "sh_prefs"
        const val USER_URL = "user_url"
    }
}