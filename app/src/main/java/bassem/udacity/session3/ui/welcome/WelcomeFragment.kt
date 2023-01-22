package bassem.udacity.session3.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import bassem.udacity.session3.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater)
            .apply {
                btnLetsStart.setOnClickListener {
                    findNavController().navigate(
                        directions = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
                    )
                }
            }

        return binding.root
    }
}