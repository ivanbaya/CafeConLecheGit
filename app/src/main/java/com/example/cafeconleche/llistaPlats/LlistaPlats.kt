package com.example.cafeconleche.llistaPlats

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.*
import com.example.cafeconleche.database.GetDatabase
import com.example.cafeconleche.database.comanda.LlistaComanda
import com.example.cafeconleche.databinding.FragmentLlistaPlatsBinding
import com.example.cafeconleche.plats.SharedViewModel
import com.example.cafeconleche.prefs.SharedApp
import java.text.SimpleDateFormat
import java.util.*

class LlistaPlats : Fragment() {
    var preu = 0.0
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
        model.preu1.observe(viewLifecycleOwner, Observer {
            sumaPreu(it, binding)
        })
        model.preu2.observe(viewLifecycleOwner, Observer {
            sumaPreu(it, binding)
        })
        model.preu3.observe(viewLifecycleOwner, Observer {
            sumaPreu(it, binding)
        })
        binding.buttonSave.setOnClickListener { view: View ->
            val c = Calendar.getInstance().time
            val df = SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault())
            val formattedDate: String = df.format(c)
            Toast.makeText(context, "Comanda realizada", Toast.LENGTH_SHORT).show()
            llistaPlatsViewModel.novaLlista(LlistaComanda(0L,binding.textPlat1.text.toString(),binding.textPlat2.text.toString(),binding.textPostre.text.toString(), SharedApp.prefs.name.toString(), formattedDate, preu))
            view.findNavController().navigate(R.id.action_llistaPlats_to_ordenesLista)
        }
        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)
        return binding.root
    }
    fun sumaPreu(num: Double, binding: FragmentLlistaPlatsBinding) {
        preu += num
        binding.textViewPreu.text = "Total: "+preu+"€"
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