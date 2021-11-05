package com.syncq.paprikacrypto.presentation.coin_list

import com.syncq.paprikacrypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
