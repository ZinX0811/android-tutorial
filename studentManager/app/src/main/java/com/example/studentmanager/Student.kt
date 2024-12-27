package com.example.studentmanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // Mặc định là 0 cho auto-generate
    @ColumnInfo(name = "mssv") val mssv: String,       // Thông tin MSSV
    @ColumnInfo(name = "ten") val ten: String          // Tên sinh viên
)
