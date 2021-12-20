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
import com.example.cafeconleche.databinding.FragmentPlat1Binding
import com.example.cafeconleche.databinding.FragmentPlat2Binding
import com.example.cafeconleche.databinding.FragmentRegisterBinding

class Plat3 : Fragment() {
    lateinit var model: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPlat2Binding>(
            inflater,
            R.layout.fragment_plat2, container, false
        )

        var options = arrayOf("Natillas", "Yogur", "Polo", "Helado", "Ice cream")
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.spinner.adapter = ArrayAdapter(
            requireActivity().applicationContext,
            android.R.layout.simple_list_item_1,
            options
        )
        binding.button.setOnClickListener { view: View ->
            model.sendPostre(binding.spinner.getSelectedItem().toString())
            view.findNavController().navigate(R.id.action_plat3_to_llistaPlats)
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