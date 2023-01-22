package bassem.udacity.session3.ui.home

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import bassem.udacity.session3.R
import bassem.udacity.session3.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentHomeBinding

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.userName = args.name

        addMenu()

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

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) =
        menuInflater.inflate(R.menu.menu_logout, menu)

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
        if (menuItem.itemId == R.id.menu_logout) {
            findNavController().navigate(
                directions = HomeFragmentDirections.actionHomeFragmentToWelcomeFragment()
            )
            true
        } else false

}