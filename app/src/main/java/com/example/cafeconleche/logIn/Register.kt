package com.example.cafeconleche.logIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafeconleche.LlistaPlatsViewModel
import com.example.cafeconleche.LlistaPlatsViewModelFactory
import com.example.cafeconleche.R
import com.example.cafeconleche.database.ComandaDatabase
import com.example.cafeconleche.database.LlistaComanda
import com.example.cafeconleche.databinding.FragmentRegisterBinding
import com.example.cafeconleche.usersDatabase.UserDatabase
import com.example.cafeconleche.usersDatabase.Usuaris


class Register : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)
        binding.buttonRegister.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_register_to_logIn)
        }

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDAO
        val viewModelFactory = UsuarisViewModelFactory(dataSource, application)

        val llistaUsersViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(UsuarisViewModel::class.java)

        binding.buttonLogIn.setOnClickListener { view: View ->
            if(llistaUsersViewModel.comprobarUsuari(binding.editTextEmail.text.toString()) == false){
                llistaUsersViewModel.nouUsuari(Usuaris(binding.editTextEmail.text.toString(),binding.editTextNombre.text.toString(),binding.editTextTelefono.text.toString(), binding.editTextPassword.text.toString()))
                view.findNavController().navigate(R.id.action_register_to_logIn)
            }else{
                Toast.makeText(context, "Ya existe una cuenta con ese Email", Toast.LENGTH_SHORT).show()
            }
        }
        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)
        return binding.root
    }
}