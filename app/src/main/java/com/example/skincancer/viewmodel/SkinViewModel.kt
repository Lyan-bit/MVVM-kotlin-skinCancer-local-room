package com.example.skincancer.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.skincancer.SkinCancer
import com.example.skincancer.database.Repository
import com.example.skincancer.model.SkinCancerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.ArrayList

class SkinViewModel constructor(context: Context): ViewModel() {

    companion object {
        private val repository by lazy { Repository() }
        private var instance: SkinViewModel? = null
        fun getInstance(context: Context): SkinViewModel {
            return instance ?: SkinViewModel(context)
        }
    }

    val allSkinCancers: LiveData<List<SkinCancerEntity>> = repository.allSkinCancers.asLiveData()
    val allSkinCancerIds: LiveData<List<String>> = repository.allSkinCancerids.asLiveData()
    val allSkinCancerDatess: LiveData<List<String>> = repository.allSkinCancerdatess.asLiveData()
    val allSkinCancerImagess: LiveData<List<String>> = repository.allSkinCancerimagess.asLiveData()
    val allSkinCancerOutcomes: LiveData<List<String>> = repository.allSkinCanceroutcomes.asLiveData()
    private var currentSkinCancer: SkinCancerEntity? = null
    private var currentSkinCancers: List<SkinCancerEntity> = ArrayList()

    fun searchBySkinCancerid(searchQuery: String): LiveData<List<SkinCancerEntity>>  {
        return repository.searchBySkinCancerid(searchQuery).asLiveData()
    }

    fun searchBySkinCancerdates(searchQuery: String): LiveData<List<SkinCancerEntity>>  {
        return repository.searchBySkinCancerdates(searchQuery).asLiveData()
    }

    fun searchBySkinCancerimages(searchQuery: String): LiveData<List<SkinCancerEntity>>  {
        return repository.searchBySkinCancerimages(searchQuery).asLiveData()
    }

    fun searchBySkinCanceroutcome(searchQuery: String): LiveData<List<SkinCancerEntity>>  {
        return repository.searchBySkinCanceroutcome(searchQuery).asLiveData()
    }


    fun getSkinCancerByPK(_val: String): Flow<SkinCancer> {
        val res: Flow<List<SkinCancerEntity>> = repository.searchBySkinCancerid(_val)
        return res.map { skinCancer ->
            val itemx = SkinCancer.createByPKSkinCancer(_val)
            if (skinCancer.isNotEmpty()) {
                itemx.id = skinCancer[0].id
            }
            if (skinCancer.isNotEmpty()) {
                itemx.dates = skinCancer[0].dates
            }
            if (skinCancer.isNotEmpty()) {
                itemx.images = skinCancer[0].images
            }
            if (skinCancer.isNotEmpty()) {
                itemx.outcome = skinCancer[0].outcome
            }
            itemx
        }
    }

    suspend fun createSkinCancer(_x: SkinCancerEntity) {
        repository.createSkinCancer(_x)
        currentSkinCancer = _x
    }

    suspend fun editSkinCancer(_x: SkinCancerEntity) {
        repository.updateSkinCancer(_x)
        currentSkinCancer = _x
    }

    fun setSelectedSkinCancer(x: SkinCancerEntity) {
        currentSkinCancer = x
    }

    suspend fun deleteSkinCancer(_id: String) {
        repository.deleteSkinCancer(_id)
        currentSkinCancer = null
    }

    suspend fun searchSkinCancer(dates: String) : ArrayList<SkinCancer> {
        currentSkinCancers = repository.searchBySkinCancerdates2(dates)
        var itemsList = ArrayList<SkinCancer>()
        for (x in currentSkinCancers.indices) {
            val vo: SkinCancerEntity = currentSkinCancers[x]
            val itemx = SkinCancer.createByPKSkinCancer(vo.id)
            itemx.id = vo.id
            itemx.dates = vo.dates
            itemx.images = vo.images
            itemx.outcome = vo.outcome
            itemsList.add(itemx)
        }
        return itemsList
    }

    suspend fun listSkinCancer(): List<SkinCancerEntity> {
        currentSkinCancers = repository.listSkinCancer()
        return currentSkinCancers
    }

    suspend fun listAllSkinCancer(): ArrayList<SkinCancer> {
        currentSkinCancers = repository.listSkinCancer()
        var res = ArrayList<SkinCancer>()
        for (x in currentSkinCancers.indices) {
            val vo: SkinCancerEntity = currentSkinCancers[x]
            val itemx = SkinCancer.createByPKSkinCancer(vo.id)
            itemx.id = vo.id
            itemx.dates = vo.dates
            itemx.images = vo.images
            itemx.outcome = vo.outcome
            res.add(itemx)
        }
        return res
    }

    suspend fun stringListSkinCancer(): List<String> {
        currentSkinCancers = repository.listSkinCancer()
        val res: ArrayList<String> = ArrayList()
        for (x in currentSkinCancers.indices) {
            res.add(currentSkinCancers[x].toString())
        }
        return res
    }

    suspend fun getSkinCancerByPK2(_val: String): SkinCancer? {
        val res: List<SkinCancerEntity> = repository.searchBySkinCancerid2(_val)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: SkinCancerEntity = res[0]
            val itemx = SkinCancer.createByPKSkinCancer(_val)
            itemx.id = vo.id
            itemx.dates = vo.dates
            itemx.images = vo.images
            itemx.outcome = vo.outcome
            itemx
        }
    }

    suspend fun retrieveSkinCancer(_val: String): SkinCancer? {
        return getSkinCancerByPK2(_val)
    }

    suspend fun allSkinCancerIds(): ArrayList<String> {
        currentSkinCancers = repository.listSkinCancer()
        val res: ArrayList<String> = ArrayList()
        for (skincancer in currentSkinCancers.indices) {
            res.add(currentSkinCancers[skincancer].id)
        }
        return res
    }

    fun setSelectedSkinCancer(i: Int) {
        if (i < currentSkinCancers.size) {
            currentSkinCancer = currentSkinCancers[i]
        }
    }

    fun getSelectedSkinCancer(): SkinCancerEntity? {
        return currentSkinCancer
    }

    suspend fun persistSkinCancer(_x: SkinCancer) {
        val vo = SkinCancerEntity(_x.id, _x.dates, _x.images, _x.outcome)
        repository.updateSkinCancer(vo)
        currentSkinCancer = vo
    }

    suspend fun searchBySkinCancerid2(idx: String): List<SkinCancerEntity> {
        currentSkinCancers = repository.searchBySkinCancerid2(idx)
        return currentSkinCancers
    }
    suspend fun searchBySkinCancerdates2(datesx: String): List<SkinCancerEntity> {
        currentSkinCancers = repository.searchBySkinCancerdates2(datesx)
        return currentSkinCancers
    }
    suspend fun searchBySkinCancerimages2(imagesx: String): List<SkinCancerEntity> {
        currentSkinCancers = repository.searchBySkinCancerimages2(imagesx)
        return currentSkinCancers
    }
    suspend fun searchBySkinCanceroutcome2(outcomex: String): List<SkinCancerEntity> {
        currentSkinCancers = repository.searchBySkinCanceroutcome2(outcomex)
        return currentSkinCancers
    }
}