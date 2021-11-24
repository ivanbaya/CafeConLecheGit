package com.example.cafeconleche

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.database.ComandaDatabase
import com.example.cafeconleche.databinding.FragmentPlat1Binding
import com.example.cafeconleche.databinding.FragmentRegisterBinding

class Plat1 : Fragment() {
    lateinit var model: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPlat1Binding>(inflater,
            R.layout.fragment_plat1,container,false)

        var options = arrayOf("Gazpacho","Sopa","Ensalada")
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.spinner.adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_list_item_1,options)
        binding.buttonSiguiente.setOnClickListener { view : View ->
            model.sendPlat1(binding.spinner.getSelectedItem().toString())
            view.findNavController().navigate(R.id.action_plat1_to_plat2)
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