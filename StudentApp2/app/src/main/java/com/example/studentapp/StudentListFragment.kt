package com.example.studentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class StudentListFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val students = mutableListOf<Student>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)
        listView = view.findViewById(R.id.studentListView)

        adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            students.map { "${it.name} (${it.studentId})" }
        )
        listView.adapter = adapter

        registerForContextMenu(listView) // Context menu
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.addNew) {
            findNavController().navigate(R.id.action_studentListFragment_to_addEditStudentFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when (item.itemId) {
            R.id.edit -> {
                val selectedStudent = students[info.position]
                val action = StudentListFragmentDirections.actionStudentListFragmentToAddEditStudentFragment(
                    selectedStudent.name,
                    selectedStudent.studentId
                )
                findNavController().navigate(action)
            }
            R.id.remove -> {
                students.removeAt(info.position)
                adapter.notifyDataSetChanged()
            }
        }
        return super.onContextItemSelected(item)
    }
}
