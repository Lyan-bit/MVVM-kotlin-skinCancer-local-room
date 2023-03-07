package com.example.skincancer.database

import androidx.room.*
import com.example.skincancer.model.SkinCancerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SkinCancerEntityDAO {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM skinCancer_table")
    fun listSkinCancers(): Flow<List<SkinCancerEntity>>

    //Read (list id)
	@Query("SELECT id FROM skinCancer_table")
	fun listSkinCancerids (): Flow<List<String>>
    //Read (list dates)
	@Query("SELECT dates FROM skinCancer_table")
	fun listSkinCancerdatess (): Flow<List<String>>
    //Read (list images)
	@Query("SELECT images FROM skinCancer_table")
	fun listSkinCancerimagess (): Flow<List<String>>
    //Read (list outcome)
	@Query("SELECT outcome FROM skinCancer_table")
	fun listSkinCanceroutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createSkinCancer (skinCancer: SkinCancerEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM skinCancer_table")
    suspend fun listSkinCancer(): List<SkinCancerEntity>

    //Update
    @Update
    suspend fun updateSkinCancer (skinCancer: SkinCancerEntity)

    //Delete all records
    @Query("DELETE FROM skinCancer_table")
    suspend fun deleteSkinCancers ()

    //Delete a single record by PK
    @Query("DELETE FROM skinCancer_table WHERE id = :id")
    suspend fun deleteSkinCancer (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  skinCancer_table WHERE id LIKE :searchQuery ")
	fun searchBySkinCancerid(searchQuery: String): Flow<List<SkinCancerEntity>>
	@Query("SELECT * FROM  skinCancer_table WHERE dates LIKE :searchQuery ")
	fun searchBySkinCancerdates(searchQuery: String): Flow<List<SkinCancerEntity>>
	@Query("SELECT * FROM  skinCancer_table WHERE images LIKE :searchQuery ")
	fun searchBySkinCancerimages(searchQuery: String): Flow<List<SkinCancerEntity>>
	@Query("SELECT * FROM  skinCancer_table WHERE outcome LIKE :searchQuery ")
	fun searchBySkinCanceroutcome(searchQuery: String): Flow<List<SkinCancerEntity>>

    //Search with suspend
    @Query("SELECT * FROM  skinCancer_table WHERE id LIKE :searchQuery")
	suspend fun searchBySkinCancerid2(searchQuery: String): List<SkinCancerEntity>
    @Query("SELECT * FROM  skinCancer_table WHERE dates LIKE :searchQuery")
	suspend fun searchBySkinCancerdates2(searchQuery: String): List<SkinCancerEntity>
    @Query("SELECT * FROM  skinCancer_table WHERE images LIKE :searchQuery")
	suspend fun searchBySkinCancerimages2(searchQuery: String): List<SkinCancerEntity>
    @Query("SELECT * FROM  skinCancer_table WHERE outcome LIKE :searchQuery")
	suspend fun searchBySkinCanceroutcome2(searchQuery: String): List<SkinCancerEntity>

}
