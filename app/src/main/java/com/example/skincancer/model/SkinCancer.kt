package com.example.skincancer

import java.util.HashMap

class SkinCancer {

    init {
        skinCancer_allInstances.add(this)
    }

    companion object {
        var skinCancer_allInstances = ArrayList<SkinCancer>()
        fun createSkinCancer(): SkinCancer {
            return SkinCancer()
        }
        
        var skinCancer_index: HashMap<String, SkinCancer> = HashMap<String, SkinCancer>()
        
        fun createByPKSkinCancer(idx: String): SkinCancer {
            var result: SkinCancer? = skinCancer_index[idx]
            if (result != null) { return result }
                  result = SkinCancer()
                  skinCancer_index.put(idx,result)
                  result.id = idx
                  return result
        }
        
		fun killSkinCancer(idx: String?) {
            val rem = skinCancer_index[idx] ?: return
            val remd = ArrayList<SkinCancer>()
            remd.add(rem)
            skinCancer_index.remove(idx)
            skinCancer_allInstances.removeAll(remd)
        }        
    }

    var id = ""  /* identity */
    var dates = "" 
    var images = "" 
    var outcome = ""  /* derived */

}
