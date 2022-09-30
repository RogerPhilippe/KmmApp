package br.com.phs.kmmapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.phs.shared.entity.RocketLaunch

class LaunchesRvAdapter: ListAdapter<RocketLaunch, LaunchesRvAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RocketLaunch>() {

            override fun areItemsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
                return oldItem.flightNumber == newItem.flightNumber
            }

            override fun areContentsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
                return oldItem == newItem
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(getItem(position)) {

            val missionNameTextView = holder.itemView.findViewById<TextView>(R.id.missionName)
            val launchYearTextView = holder.itemView.findViewById<TextView>(R.id.launchYear)
            val launchSuccessTextView = holder.itemView.findViewById<TextView>(R.id.launchSuccess)
            val missionDetailsTextView = holder.itemView.findViewById<TextView>(R.id.details)

            val ctx = holder.itemView.context
            missionNameTextView.text = ctx.getString(R.string.mission_name_field, this.missionName)
            launchYearTextView.text = ctx.getString(R.string.launch_year_field, this.launchYear.toString())
            missionDetailsTextView.text = ctx.getString(R.string.details_field, this.details ?: "")

            val launchSuccess = this.launchSuccess
            if (launchSuccess != null ) {
                if (launchSuccess) {
                    launchSuccessTextView.text = ctx.getString(R.string.successful)
                    launchSuccessTextView.setTextColor((ContextCompat.getColor(ctx, R.color.colorSuccessful)))
                } else {
                    launchSuccessTextView.text = ctx.getString(R.string.unsuccessful)
                    launchSuccessTextView.setTextColor((ContextCompat.getColor(ctx, R.color.colorUnsuccessful)))
                }
            } else {
                launchSuccessTextView.text = ctx.getString(R.string.no_data)
                launchSuccessTextView.setTextColor((ContextCompat.getColor(ctx, R.color.colorNoData)))
            }

        }
    }

    class ViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent,false)
    )

}