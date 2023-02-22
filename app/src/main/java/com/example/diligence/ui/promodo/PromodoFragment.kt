package com.example.diligence.ui.promodo

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diligence.databinding.FragmentPromodoBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat
import java.text.NumberFormat

class PromodoFragment : Fragment() {

    private var _binding: FragmentPromodoBinding? = null
    private lateinit var timer: CountDownTimer
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPromodoBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

        binding.progressBar.max = 100000

         timer = object : CountDownTimer(60000*25, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                binding.progressBar.progress = ((millisUntilFinished / 1500) * 100) .toInt()
                binding.countDownTextView.text = "$min:$sec"
            }
            override fun onFinish() {
                binding.countDownTextView.text = "fininshed"
            }
        }
        timer.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
        _binding = null

    }
}