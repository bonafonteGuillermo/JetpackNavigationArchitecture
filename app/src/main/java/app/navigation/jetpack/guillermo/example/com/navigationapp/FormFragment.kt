package app.navigation.jetpack.guillermo.example.com.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_form.*

/**
 * A simple [Fragment] subclass.
 *
 */
class FormFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floating_button_confirm_transaction.setOnClickListener {
            val action = FormFragmentDirections.actionFormFragmentToSubmitFragment()
            action.setAmount(1000)
            findNavController().navigate(action)

        }
    }
}