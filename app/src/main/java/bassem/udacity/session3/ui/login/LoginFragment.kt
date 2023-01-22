package bassem.udacity.session3.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import bassem.udacity.session3.R
import bassem.udacity.session3.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.viewModel = viewModel

        observeData()

        return binding.root
    }

    private fun observeData() {
        viewModel.isUserLoggedIn.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(
                    directions = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                        viewModel.user.value?.userName ?: getString(
                            R.string.student
                        )
                    )
                )
            }
        }
    }

}