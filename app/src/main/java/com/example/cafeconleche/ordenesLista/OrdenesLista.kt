package com.example.cafeconleche.ordenesLista

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.R
import com.example.cafeconleche.database.GetDatabase
import com.example.cafeconleche.databinding.FragmentOrdenesListaBinding
import com.example.cafeconleche.llistaPlats.LlistaPlatsViewModel
import com.example.cafeconleche.llistaPlats.LlistaPlatsViewModelFactory


class OrdenesLista : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentOrdenesListaBinding>(inflater,
            R.layout.fragment_ordenes_lista,container,false)
        binding.setLifecycleOwner(this)

        val application = requireNotNull(this.activity).application
        val dataSource = GetDatabase.getInstance(application).comandaDatabaseDAO()
        val viewModelFactory = LlistaPlatsViewModelFactory(dataSource, application)

        val llistaPlatsViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(LlistaPlatsViewModel::class.java)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter= OrdenesListaAdapter(
            application,
            llistaPlatsViewModel.comandas
        )
        return binding.root
    }
}