package com.projectx.projectx.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.projectx.projectx.R

/**
 * Created by Ajith E R on 13/11/17.
 * @brief Delete Account Action Screen - fragment
 */

class DeleteMyAccountScreen : Fragment() {
    private var deleteButton: Button? = null
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_delete_my_account_screen, container, false)
        deleteButton = view.findViewById(R.id.btn_user_account_delete)
        deleteButton!!.setOnClickListener{deleteUserAccount()}
        return view
    }

    fun deleteUserAccount() {
        if (mListener != null) {
            mListener!!.onFragmentInteractionDeleteUserAccount()
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
        fun onFragmentInteractionDeleteUserAccount()
    }

}
