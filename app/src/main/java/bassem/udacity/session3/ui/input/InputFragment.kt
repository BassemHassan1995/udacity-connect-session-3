package bassem.udacity.session3.ui.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import bassem.udacity.session3.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding
    private val viewModel by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(inflater)
        binding.viewModel = viewModel

        observeData()

        return binding.root
    }

    private fun observeData() {
        viewModel.calculatedWeight.observe(viewLifecycleOwner) {
            if (it > 0) {
                findNavController().navigate(
                    directions = InputFragmentDirections.actionInputFragmentToWeightFragment()
                )
            }
        }
    }


}