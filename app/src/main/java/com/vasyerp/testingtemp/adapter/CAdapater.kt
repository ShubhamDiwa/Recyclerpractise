package com.vasyerp.testingtemp.adapter

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vasyerp.testingtemp.R
import com.vasyerp.testingtemp.interfac.EditData
import com.vasyerp.testingtemp.model.ProfileDto

class CAdapater(var context: Context, private var List: ArrayList<ProfileDto>,private val listner:EditData) :
    RecyclerView.Adapter<CAdapater.mViewHolder>() {
    class mViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var profileImg = itemview.findViewById<ImageView>(R.id.profileimgview)
        var firstname = itemview.findViewById<TextView>(R.id.tvFname)
        var lastname = itemview.findViewById<TextView>(R.id.tvLname)
        var editImg = itemview.findViewById<ImageView>(R.id.imgEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return mViewHolder(view)

    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val item = List[position]

        Glide.with(context).load(item.image).into(holder.profileImg)
        holder.firstname.setText(item.firstname)
        holder.lastname.setText(item.lastname)

        holder.editImg.setOnClickListener {
            showpopupMenu(holder.editImg, item,position)
//            listner.onClick(position,item.firstname)
        }

    }

    private fun editDialog(item: ProfileDto, context: Context) {
        val dialog = AlertDialog.Builder(context).create()
        val view = LayoutInflater.from(context).inflate(R.layout.edit_custom_dialog, null)
        val nameEditText = view.findViewById<EditText>(R.id.edtFname)
        val lastNameEditText = view.findViewById<EditText>(R.id.edtLname)
        val dismis = view.findViewById<TextView>(R.id.tvDismiss)
        val save = view.findViewById<TextView>(R.id.tvSave)
        // Set initial values to the EditTexts
        nameEditText.setText(item.firstname)
        lastNameEditText.setText(item.lastname)

        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 60)
        dialog.window?.setBackgroundDrawable(inset)
        dialog.setView(view)
        dialog.setCancelable(false)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.window?.attributes?.windowAnimations = R.style.animation
        dialog.setContentView(view)


        save.setOnClickListener {
            val newName = nameEditText.text.toString()
            val newLastName = lastNameEditText.text.toString()
            // Update the data source with the new values
            item.firstname = newName
            item.lastname = newLastName
            notifyDataSetChanged()
            dialog.dismiss()
            // Notify the adapter that data has change
        }

        dismis.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun showpopupMenu(view: View, item: ProfileDto, position: Int) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.inflate(R.menu.custom)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit -> {
                    editDialog(item, context)
                    true
                }

                R.id.delete -> {
                    listner.delete(position)
                    notifyDataSetChanged()
                    true
                }

                else -> {
                    false
                }
            }
        }
        popupMenu.show()
    }


}