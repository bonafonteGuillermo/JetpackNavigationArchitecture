package app.navigation.jetpack.guillermo.example.com.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_list_transfers.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ListTransfers : Fragment() {

    val data : List<Transfer> = listOf(
            Transfer("Christmas dinner",50),
            Transfer("Apartment rent",650),
            Transfer("Loan settlement",1800),
            Transfer("John's birthday gift",15)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_transfers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TransferAdapter{ itemClicked(it)}
        recycler.adapter = adapter
        adapter.data = data
    }

    private fun itemClicked(item: Transfer) {
        var action
                = ListTransfersDirections.actionListTransfersToDetailFragment()
        action.setItem(item)


    }
}