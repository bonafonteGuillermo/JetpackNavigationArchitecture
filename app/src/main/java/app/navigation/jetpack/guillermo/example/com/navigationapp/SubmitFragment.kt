package app.navigation.jetpack.guillermo.example.com.navigationapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_submit.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SubmitFragment : Fragment() {

    private var amountValue : Int = 0
    private var conceptValue : String = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View?
    {
        arguments?.let {
            val saveArgs = SubmitFragmentArgs.fromBundle(it)
            amountValue = saveArgs.amountArg
            conceptValue = saveArgs.conceptArg
        }
        return inflater.inflate(R.layout.fragment_submit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amount_resume.text = getString(R.string.resume_amount_value,amountValue.toString())
        concept_resume.text = conceptValue

        resume_cancel_button.setOnClickListener{
            findNavController().navigateUp()
        }

        resume_accept_button.setOnClickListener{
            var action = SubmitFragmentDirections.ActionSubmitFragmentDestinationToResultFragmentDestination()
            action.setAcceptedAmountArg(amountValue)
            action.setAcceptedConceptArg(conceptValue)
            findNavController().navigate(action)
        }
    }
}