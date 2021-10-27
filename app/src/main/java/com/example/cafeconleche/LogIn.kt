package com.example.cafeconleche

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeconleche.databinding.FragmentLogInBinding


class LogIn : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLogInBinding>(inflater,
            R.layout.fragment_log_in,container,false)
        binding.buttonRegister.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_logIn_to_register)
        }
        binding.buttonLogIn.setOnClickListener { view : View ->
            if(binding.editTextEmail.text.toString() == "ivanbaya@gmail.com" && binding.editTextPassword.text.toString() == "patata"){//&& binding.editTextPassword.text.toString() == "patata"
                view.findNavController().navigate(R.id.action_logIn_to_plat1)
            }
        }
        return binding.root
    }
}