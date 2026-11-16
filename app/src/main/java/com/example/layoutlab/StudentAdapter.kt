package com.example.layoutlab

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutlab.databinding.ItemStudentBinding
import kotlin.math.log


data class Student (val name: String, val score: Int)
// --- OLD CODE COMMENTED OUT ---
// class StudentAdapter (private val items: List<Student>) :
//     RecyclerView.Adapter<StudentAdapter.VH>() {

// --- NEW CODE ---
class StudentAdapter(
    private val items: List<Student>,
    private val onClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.VH>() {

    class VH(val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val student = items[position]
        holder.binding.txtName.text = student.name
        holder.binding.txtScore.text = "Marks: ${student.score}"

        // --- NEW CODE: Set click listener on the whole row ---
        holder.itemView.setOnClickListener {
            onClick(student)
        }
    }

    override fun getItemCount() = items.size
}