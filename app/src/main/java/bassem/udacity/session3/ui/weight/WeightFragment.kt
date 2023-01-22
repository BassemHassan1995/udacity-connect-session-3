package bassem.udacity.session3.ui.weight

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import bassem.udacity.session3.R
import bassem.udacity.session3.databinding.FragmentWeightBinding

class WeightFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentWeightBinding
    private val viewModel by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeightBinding.inflate(inflater)
        binding.viewModel = viewModel


        addMenu()
        observeData()

        return binding.root
    }

    private fun addMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
//
//        menuHost.addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) =
//                menuInflater.inflate(R.menu.menu_new, menu)
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
//                if (menuItem.itemId == R.id.testFragment) {
//                    viewModel.onNewCalculationButtonClicked()
//                    true
//                } else false
//        })
    }

    private fun observeData() {
        viewModel.calculatedWeight.observe(viewLifecycleOwner) {
            if (it == -1) {
                findNavController().navigate(
                    directions = WeightFragmentDirections.actionWeightFragmentToWelcomeFragment()
                )
            }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) =
        menuInflater.inflate(R.menu.menu_new, menu)

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
        if (menuItem.itemId == R.id.testFragment) {
            viewModel.onNewCalculationButtonClicked()
            true
        } else false

}