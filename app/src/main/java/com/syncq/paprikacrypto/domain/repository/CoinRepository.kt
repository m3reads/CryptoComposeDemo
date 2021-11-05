package com.syncq.paprikacrypto.domain.repository

import com.syncq.paprikacrypto.data.remote.dto.CoinDetailDto
import com.syncq.paprikacrypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}