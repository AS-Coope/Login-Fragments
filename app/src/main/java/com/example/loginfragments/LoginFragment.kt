package com.example.loginfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loginfragments.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username = binding.usernameEditText
        password = binding.passwordEditText
        loginButton = binding.loginBtn

    }

    override fun onResume() {
        super.onResume()

        loginButton?.setOnClickListener{
            Toast.makeText(requireContext(), "Login Button works", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}