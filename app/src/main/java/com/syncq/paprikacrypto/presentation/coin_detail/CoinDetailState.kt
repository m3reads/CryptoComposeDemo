package com.syncq.paprikacrypto.presentation.coin_detail

import com.syncq.paprikacrypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
