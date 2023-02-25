package com.example.diligence.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diligence.databinding.FragmentFirstBinding
import kotlin.time.Duration.Companion.seconds

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val MOCK : Long = 10000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.max = MOCK.toInt()

        object: CountDownTimer(MOCK, 10){
            override fun onTick(millisUntilFinished: Long) {
                binding.progressBar.progress = millisUntilFinished.toInt()
                binding.progressBarTextView.text = "${(millisUntilFinished/1000).seconds}"
            }

            override fun onFinish() {
                binding.progressBar.setProgress(binding.progressBar.max,true)
                binding.progressBarTextView.text = "00:00"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}