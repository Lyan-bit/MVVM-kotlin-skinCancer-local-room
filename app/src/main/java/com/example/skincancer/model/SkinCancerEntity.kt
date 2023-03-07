package com.example.skincancer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skinCancer_table")
data class SkinCancerEntity (
    @PrimaryKey
    val id: String, 
    val dates: String, 
    val images: String, 
    val outcome: String
)
