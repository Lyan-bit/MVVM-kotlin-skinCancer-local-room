package com.example.skincancer.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.skincancer.fragments.CreateSkinCancerFragment
import com.example.skincancer.fragments.EditSkinCancerFragment
import com.example.skincancer.fragments.ImageRecognitionFragment
import com.example.skincancer.fragments.SearchSkinCancerdatesFragment
import com.example.skincancer.fragments.DeleteSkinFragment
import com.example.skincancer.fragments.ListSkinFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        private val TABTITLES = arrayOf("+SkinCancer", "ListSkinCancer", "EditSkinCancer", "DeleteSkinCancer", "SearchSkinCancerdates", "ImageRecognition")
    }

    override fun getItem(position: Int): Fragment {
        // instantiate a fragment for the page.
        if (position == 0) {
            return CreateSkinCancerFragment.newInstance(mContext)    }
        else if (position == 1) {
            return ListSkinFragment.newInstance(mContext)    }
        else if (position == 2) {
            return EditSkinCancerFragment.newInstance(mContext)    }
        else if (position == 3) {
            return DeleteSkinFragment.newInstance(mContext)    }
        else if (position == 4) {
            return SearchSkinCancerdatesFragment.newInstance(mContext)    }
        else if (position == 5) {
            return ImageRecognitionFragment.newInstance(mContext)    }
        return CreateSkinCancerFragment.newInstance(mContext)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TABTITLES[position]
    }

    override fun getCount(): Int {
        return 6
    }
}
