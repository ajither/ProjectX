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
 * @brief Action Select Like or Home Screen - fragment
 */

class ActionLikeDislike : Fragment() {

    private var btnShowLikeDislike: Button? = null
    private var btnGoHome: Button? = null
    private var mListener: OnFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_action_like_dislike, container, false)
        btnShowLikeDislike = view.findViewById(R.id.btn_action_like_dislike)
        btnGoHome = view.findViewById(R.id.btn_action_gohome)
        btnShowLikeDislike!!.setOnClickListener { onButtonPressed("like")}
        btnGoHome!!.setOnClickListener { onButtonPressed("home")}
        return view;
    }
    // Button Action Handler
    fun onButtonPressed(s : String) {
        if (mListener != null) {
            if(s.equals("like")){
                mListener!!.onFragmentInteractionShowLikeDislike()
            }else{
                mListener!!.onFragmentInteractionGoHome()
            }
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
        fun onFragmentInteractionShowLikeDislike()
        fun onFragmentInteractionGoHome();
    }

}