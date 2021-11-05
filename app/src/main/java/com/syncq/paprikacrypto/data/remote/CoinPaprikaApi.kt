package com.syncq.paprikacrypto.data.remote

import com.syncq.paprikacrypto.data.remote.dto.CoinDetailDto
import com.syncq.paprikacrypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String):CoinDetailDto
}