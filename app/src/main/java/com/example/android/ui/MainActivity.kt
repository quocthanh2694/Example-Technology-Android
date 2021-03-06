package com.example.android.ui

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.android.R
import com.example.android.base.BaseActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int =
        R.layout.activity_main

    override fun initView() {}

    override fun initData() {}

    override fun customToolBar(visibility: Int, title: String?) {
        if (visibility == View.VISIBLE) {
            appBar.visibility = visibility
            toolbar.title = title
            toolbar.setNavigationOnClickListener { v: View? -> onBackPressed() }
            enableLayoutBehaviour()
        } else {
            appBar.visibility = visibility
            disableLayoutBehaviour()
        }
    }

    private fun enableLayoutBehaviour() {
        val params: CoordinatorLayout.LayoutParams =
            constraintLayout.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = AppBarLayout.ScrollingViewBehavior()
        constraintLayout.requestLayout()
    }

    private fun disableLayoutBehaviour() {
        val params: CoordinatorLayout.LayoutParams =
            constraintLayout.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = null
        constraintLayout.requestLayout()
    }
}
