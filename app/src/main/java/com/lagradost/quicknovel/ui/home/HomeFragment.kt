package com.lagradost.quicknovel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lagradost.quicknovel.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_mainpage.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val apis = ArrayList<MainAPI>()
        for (api in MainActivity.apis) {
            if (api.hasMainPage) {
                println("API::: " + api.name)
                apis.add(api)
            }
        }
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = context?.let {
            BrowseAdapter(
                it,
                apis,
                home_browselist,
            )
        }
        home_browselist.adapter = adapter
        home_browselist.layoutManager = GridLayoutManager(context, 1)
    }
}