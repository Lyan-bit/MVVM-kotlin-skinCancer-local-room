package com.example.skincancer.database

import com.example.skincancer.SkincancerApplication
import com.example.skincancer.model.SkinCancerEntity
import kotlinx.coroutines.flow.Flow

class Repository : SkinCancerRepository {

    private val skinCancerDAO: SkinCancerEntityDAO by lazy { SkincancerApplication.database.skinCancerDao() }

    val allSkinCancers: Flow<List<SkinCancerEntity>> = skinCancerDAO.listSkinCancers()

    val allSkinCancerids: Flow<List<String>> = skinCancerDAO.listSkinCancerids()
    val allSkinCancerdatess: Flow<List<String>> = skinCancerDAO.listSkinCancerdatess()
    val allSkinCancerimagess: Flow<List<String>> = skinCancerDAO.listSkinCancerimagess()
    val allSkinCanceroutcomes: Flow<List<String>> = skinCancerDAO.listSkinCanceroutcomes()

    //Create
    override suspend fun createSkinCancer(skinCancer: SkinCancerEntity) {
        skinCancerDAO.createSkinCancer(skinCancer)
    }

    //Read
    override suspend fun listSkinCancer(): List<SkinCancerEntity> {
        return skinCancerDAO.listSkinCancer()
    }

    //Update
    override suspend fun updateSkinCancer(skinCancer: SkinCancerEntity) {
        skinCancerDAO.updateSkinCancer(skinCancer)
    }

    //Delete all SkinCancers
    override suspend fun deleteSkinCancers() {
       skinCancerDAO.deleteSkinCancers()
    }

    //Delete a SkinCancer
	override suspend fun deleteSkinCancer(id: String) {
	   skinCancerDAO.deleteSkinCancer(id)
    }
    
     //Search with live data
     override fun searchBySkinCancerid (searchQuery: String): Flow<List<SkinCancerEntity>>  {
         return skinCancerDAO.searchBySkinCancerid(searchQuery)
     }
     
     //Search with live data
     override fun searchBySkinCancerdates (searchQuery: String): Flow<List<SkinCancerEntity>>  {
         return skinCancerDAO.searchBySkinCancerdates(searchQuery)
     }
     
     //Search with live data
     override fun searchBySkinCancerimages (searchQuery: String): Flow<List<SkinCancerEntity>>  {
         return skinCancerDAO.searchBySkinCancerimages(searchQuery)
     }
     
     //Search with live data
     override fun searchBySkinCanceroutcome (searchQuery: String): Flow<List<SkinCancerEntity>>  {
         return skinCancerDAO.searchBySkinCanceroutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchBySkinCancerid2 (id: String): List<SkinCancerEntity> {
          return skinCancerDAO.searchBySkinCancerid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchBySkinCancerdates2 (dates: String): List<SkinCancerEntity> {
          return skinCancerDAO.searchBySkinCancerdates2(dates)
     }
	     
    //Search with suspend
     override suspend fun searchBySkinCancerimages2 (images: String): List<SkinCancerEntity> {
          return skinCancerDAO.searchBySkinCancerimages2(images)
     }
	     
    //Search with suspend
     override suspend fun searchBySkinCanceroutcome2 (outcome: String): List<SkinCancerEntity> {
          return skinCancerDAO.searchBySkinCanceroutcome2(outcome)
     }
	     


}
