package com.example.studentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class AddEditStudentFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etId: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_edit_student, container, false)
        etName = view.findViewById(R.id.etStudentName)
        etId = view.findViewById(R.id.etStudentId)

        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name = etName.text.toString()
            val id = etId.text.toString()
            // Save or update logic
            findNavController().popBackStack()
        }

        return view
    }
}
