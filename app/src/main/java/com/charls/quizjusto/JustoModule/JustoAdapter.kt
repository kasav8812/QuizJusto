package com.charls.quizjusto.JustoModule


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.charls.quizjusto.R
import kotlinx.android.synthetic.main.item_profile.view.*

class JustoAdapter (private val mListProfiles: ArrayList<Results>) : RecyclerView.Adapter<JustoAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= DataViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(mListProfiles[position])

    override fun getItemCount(): Int = mListProfiles.size

    fun updateList(mList : List<Results>) {
        mListProfiles.addAll(mList)
    }

    class DataViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(profile: Results) {
            Glide.with(itemView.mIdProfileImageView.context)
                .load(profile.picture.large)
                .into(itemView.mIdProfileImageView)
            itemView.mNameTextView.text = profile.name.first
            itemView.mEmailTextView.text = profile.email
            itemView.mStreetTextview.text = profile.location.street.name
            itemView.mStateTextView.text = profile.location.state
            itemView.mCountryTextView.text = profile.location.country
            itemView.mPostcodeTextView.text = profile.location.postcode
            itemView.mCoordinatesTextView.text = profile.location.coordinates.latitude

            itemView.mUuidTextView.text = profile.login.uuid
            itemView.mUserNameTextView.text = profile.login.username
            itemView.mPasswordTextView.text = profile.login.password
            itemView.mSaltTextView.text = profile.login.salt
            itemView.mSha1TextView.text = profile.login.sha1
            itemView.mMd5TextView.text = profile.login.md5

            itemView.mPhone.text = profile.phone
            itemView.mCellTextView.text = profile.cell
        }
    }
}