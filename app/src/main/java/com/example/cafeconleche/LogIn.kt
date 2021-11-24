package com.example.cafeconleche

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.databinding.FragmentLogInBinding


class LogIn : Fragment() {
    val EMPTY_VALUE = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLogInBinding>(inflater,
            R.layout.fragment_log_in,container,false)
        binding.buttonRegister.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_logIn_to_register)
        }
        if(isSavedName()){
                binding.editTextEmail.setText(SharedApp.prefs.name)
        }
        binding.buttonLogIn.setOnClickListener { view : View ->
            if(binding.editTextEmail.text.toString() == "ivanbaya@gmail.com" && binding.editTextPassword.text.toString() == "patata"){
                SharedApp.prefs.name = binding.editTextEmail.text.toString()
                view.findNavController().navigate(R.id.action_logIn_to_plat1)
            }
        }
        return binding.root
    }
    fun isSavedName():Boolean{
        val myName = SharedApp.prefs.name
        return myName != EMPTY_VALUE
    }
}