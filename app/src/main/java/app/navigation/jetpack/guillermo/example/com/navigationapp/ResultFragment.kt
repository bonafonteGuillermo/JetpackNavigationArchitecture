package app.navigation.jetpack.guillermo.example.com.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ResultFragment : Fragment() {

    private var resultAmount: Int = 0
    private var resultConcept: String = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        arguments?.let {
            val bundle = ResultFragmentArgs.fromBundle(it)
            resultAmount = bundle.acceptedAmountArg
            resultConcept = bundle.acceptedConceptArg
        }
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_concept_result.text = resultConcept
        tv_amount_result.text = resultAmount.toString()

        button_confirm_transaction.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}