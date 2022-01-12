package com.example.cafeconleche.plats

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.R
import com.example.cafeconleche.SharedViewModel
import com.example.cafeconleche.databinding.FragmentPlat2Binding

class Plat2 : Fragment() {
    lateinit var model: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPlat2Binding>(
            inflater,
            R.layout.fragment_plat2, container, false
        )

        var options = arrayOf("Bistec", "Hamburguesa", "Macarrones", "Sepia", "Pollo")
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.spinner.adapter = ArrayAdapter(
            requireActivity().applicationContext,
            android.R.layout.simple_list_item_1,
            options
        )
        binding.button.setOnClickListener { view: View ->
            model.sendPlat2(binding.spinner.getSelectedItem().toString())
            view.findNavController().navigate(R.id.action_plat2_to_plat3)
        }
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