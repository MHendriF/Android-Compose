package com.mhendrif.jetreward.ui.screen.cart

import com.mhendrif.jetreward.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)