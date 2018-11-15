package app.navigation.jetpack.guillermo.example.com.navigationapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        tv_result.text = resultConcept.plus(resultAmount)
    }
}