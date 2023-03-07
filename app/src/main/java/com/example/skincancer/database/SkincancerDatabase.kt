package com.example.skincancer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.skincancer.model.SkinCancerEntity

@Database(entities = [(SkinCancerEntity::class)], version = 1, exportSchema = false)
abstract class SkincancerDatabase : RoomDatabase() {
    abstract fun skinCancerDao(): SkinCancerEntityDAO
}
