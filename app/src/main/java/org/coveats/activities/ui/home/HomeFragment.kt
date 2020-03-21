package org.coveats.activities.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.coveats.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val wantToHelpButton = root.findViewById<Button>(R.id.button_want_to_help)
        createWantToHelpConfirmationMessage(wantToHelpButton)

//        val textView: TextView = root.findViewById(R.id.text_home)
////        homeViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
        return root
    }

    private fun createWantToHelpConfirmationMessage(view: Button) {
        view.setOnClickListener {
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }
            builder?.apply {
                setPositiveButton(R.string.confirm) { _, _ ->
                    Toast.makeText(this.context, "confirm", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton(R.string.cancel) { _, _ ->
                    Toast.makeText(this.context, "cancel", Toast.LENGTH_SHORT).show()
                }
            }
            
            builder?.setMessage(R.string.want_to_help_warning)
                ?.setTitle(R.string.warning)
            val dialog: AlertDialog? = builder?.create()
            dialog?.show()
        }
    }
}
