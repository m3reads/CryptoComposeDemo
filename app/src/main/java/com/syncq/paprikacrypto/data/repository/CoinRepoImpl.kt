package com.syncq.paprikacrypto.data.repository

import com.syncq.paprikacrypto.data.remote.CoinPaprikaApi
import com.syncq.paprikacrypto.data.remote.dto.CoinDetailDto
import com.syncq.paprikacrypto.data.remote.dto.CoinDto
import com.syncq.paprikacrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(
    private val api:CoinPaprikaApi
)  :CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}