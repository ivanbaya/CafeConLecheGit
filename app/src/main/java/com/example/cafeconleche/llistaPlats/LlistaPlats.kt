package com.example.cafeconleche.llistaPlats

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.*
import com.example.cafeconleche.database.GetDatabase
import com.example.cafeconleche.database.comanda.LlistaComanda
import com.example.cafeconleche.databinding.FragmentLlistaPlatsBinding
import com.example.cafeconleche.prefs.SharedApp
import java.util.*

class LlistaPlats : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLlistaPlatsBinding>(inflater,
            R.layout.fragment_llista_plats,container,false)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val application = requireNotNull(this.activity).application
        val dataSource = GetDatabase.getInstance(application).comandaDatabaseDAO()
        val viewModelFactory = LlistaPlatsViewModelFactory(dataSource, application)

        val llistaPlatsViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(LlistaPlatsViewModel::class.java)

        model.plat1.observe(viewLifecycleOwner, Observer {
            binding.textPlat1.text = it
        })
        model.plat2.observe(viewLifecycleOwner, Observer {
            binding.textPlat2.text = it
        })
        model.postre.observe(viewLifecycleOwner, Observer {
            binding.textPostre.text = it
        })
        binding.buttonSave.setOnClickListener { view: View ->
            llistaPlatsViewModel.novaLlista(LlistaComanda(0L,binding.textPlat1.text.toString(),binding.textPlat2.text.toString(),binding.textPostre.text.toString(), SharedApp.prefs.name.toString(), Calendar.getInstance().getTime().toString(), 5.0))
        }
        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)
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