package com.example.cafeconleche.plats

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.R
import com.example.cafeconleche.databinding.FragmentPlat1Binding
import com.example.cafeconleche.database.GetDatabase

class Plat1 : Fragment() {
    lateinit var model: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPlat1Binding>(inflater,
            R.layout.fragment_plat1,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = GetDatabase.getInstance(application).menjarDatabaseDAO()
        val viewModelFactory = PlatsViewModelFactory(dataSource, application)

        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.setnullPlat1()
        model.plat1.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                this.findNavController().navigate(R.id.action_plat1_to_plat2)
            }
        })

        val menjarsPlatsViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(PlatsViewModel::class.java)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter= PlatsAdapter(
            application,
            menjarsPlatsViewModel.menjarsPlat1, model
        )

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}