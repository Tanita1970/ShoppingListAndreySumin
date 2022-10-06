package com.tanita_app.shoppinglistandreysumin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tanita_app.shoppinglistandreysumin.data.ShopListRepositoryImpl
import com.tanita_app.shoppinglistandreysumin.domain.DeleteShopItemUseCase
import com.tanita_app.shoppinglistandreysumin.domain.EditShopItemUseCase
import com.tanita_app.shoppinglistandreysumin.domain.GetShopListUseCase
import com.tanita_app.shoppinglistandreysumin.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(shopListRepository = repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(shopListRepository = repository)
    private val editShopItemUseCase = EditShopItemUseCase(shopListRepository = repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem = shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}