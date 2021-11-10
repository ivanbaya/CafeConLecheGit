package com.example.cafeconleche

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cafeconleche.databinding.FragmentLlistaPlatsBinding

class LlistaPlats : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLlistaPlatsBinding>(inflater,
            R.layout.fragment_llista_plats,container,false)
        return binding.root
    }
}