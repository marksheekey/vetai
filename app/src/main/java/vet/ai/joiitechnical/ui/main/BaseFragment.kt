package vet.ai.joiitechnical.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<BINDING: ViewDataBinding>: Fragment() {

    lateinit var binding: BINDING
     abstract val layoutId: Int

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is FragmentManager) {
            throw IllegalArgumentException("Wrong activity provided")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }
}