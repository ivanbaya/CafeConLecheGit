package com.example.cafeconleche.logIn

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafeconleche.R
import com.example.cafeconleche.SharedApp
import com.example.cafeconleche.databinding.FragmentLogInBinding
import com.example.cafeconleche.usersDatabase.GetDatabase


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

        val application = requireNotNull(this.activity).application
        val dataSource = GetDatabase.getInstance(application).userDatabaseDAO
        val viewModelFactory = UsuarisViewModelFactory(dataSource, application)
        val llistaUsersViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(UsuarisViewModel::class.java)

        binding.buttonLogIn.setOnClickListener { view : View ->
            if(llistaUsersViewModel.comprobarLoginUsuari(binding.editTextEmail.text.toString(),binding.editTextPassword.text.toString()) == true){
                SharedApp.prefs.name = binding.editTextEmail.text.toString()
                view.findNavController().navigate(R.id.action_logIn_to_plat1)
            }else{
                Toast.makeText(context, "Has introducido mal los datos", Toast.LENGTH_SHORT).show()
            }
        }
        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)
        return binding.root
    }
    fun isSavedName():Boolean{
        val myName = SharedApp.prefs.name
        return myName != EMPTY_VALUE
    }
}