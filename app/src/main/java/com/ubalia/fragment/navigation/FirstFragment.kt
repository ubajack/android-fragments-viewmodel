package com.ubalia.fragment.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ubalia.fragment.navigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RandomViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        val randomNumber = requireArguments().getInt("random_number")
        Log.d("FirstFragment", "Nombre aléatoire envoyé par l'activité: ${randomNumber}")
        binding.tvSampleData.text = randomNumber.toString()
         */

        viewModel.randomData.observe(viewLifecycleOwner, {
            Log.d("FirstFragment", "Nouveau nombre aléatoire : ${it}")
            binding.tvSampleData.text = it.toString()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}