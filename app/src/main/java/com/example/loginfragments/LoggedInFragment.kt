package com.example.loginfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.loginfragments.databinding.FragmentLoggedInBinding

class LoggedInFragment : Fragment() {

    private var _binding: FragmentLoggedInBinding? = null
    private val binding get() = _binding!!
    // gets the value stored in _binding that is expected to not be null

    private lateinit var usernameId: String
    private lateinit var welcomeText: TextView
    private lateinit var logOutBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            usernameId = it.getString(USERNAME).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoggedInBinding.inflate(inflater, container, false)
        return binding.root
        // given the _binding is now inflated (assigned), it is not null, hence binding can be called
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // here, all the views are associated with the fragment are bound to variables in this
        // fragment class
        logOutBtn = binding.logoutBtn
        welcomeText = binding.welcomeTxt
    }

    override fun onResume() {
        super.onResume()

        welcomeText.text = "Welcome, $usernameId"
        logOutBtn.setOnClickListener {
            val logOutAction = LoggedInFragmentDirections.actionLoggedInFragmentToLoginFragment()
            it.findNavController().navigate(logOutAction)
            Toast.makeText(requireContext(), "$usernameId has been logged out!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // basically removes the view associated with the fragment from memory
    }

    companion object{
        const val USERNAME = "username"
    }

}