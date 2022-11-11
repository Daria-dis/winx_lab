package com.example.lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lab_3.databinding.FragmentInfoBinding
import com.example.lab_3.databinding.FragmentListBinding


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textInfo.text = arguments?.getString("InfoText")
        Glide.with(view)
            .load(arguments?.getString("InfoPics"))
            .centerCrop()
            .placeholder(binding.winksPhoto.drawable)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(binding.winksPhoto)
    }

}