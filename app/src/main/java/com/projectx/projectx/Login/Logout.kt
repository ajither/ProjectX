package com.projectx.projectx.Login

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.projectx.projectx.R
import android.widget.TextView

/**
 * Created by Ajith E R on 13/11/17.
 * @brief Logout Fragment
 */

class Logout : Fragment() {
    private var btnLogout: Button? = null
    private var textDeleteAccount: TextView? = null
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_logout,
                container, false)
        btnLogout = view.findViewById(R.id.btn_user_logout)
        btnLogout!!.setOnClickListener {doUserLogout()}
        textDeleteAccount = view.findViewById(R.id.pxlDeleteAccountText)
        textDeleteAccount!!.setOnClickListener{doUserAccountDelete()}
        return view
    }

    private fun doUserAccountDelete() {
        if (mListener != null) {
            mListener!!.onFragmentInteractionDeletAccount()
        }
    }

    private fun doUserLogout() {
        if (mListener != null) {
            mListener!!.onFragmentInteractionLogout()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteractionLogout()
        fun onFragmentInteractionDeletAccount()
    }

}// Required empty public constructor
