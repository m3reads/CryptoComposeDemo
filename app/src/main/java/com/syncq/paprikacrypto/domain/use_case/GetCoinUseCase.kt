package com.syncq.paprikacrypto.domain.use_case

import com.syncq.paprikacrypto.common.Resource
import com.syncq.paprikacrypto.data.remote.dto.toCoin
import com.syncq.paprikacrypto.data.remote.dto.toCoinDetail
import com.syncq.paprikacrypto.domain.model.Coin
import com.syncq.paprikacrypto.domain.model.CoinDetail
import com.syncq.paprikacrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>("An Unexcpedted"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldnt reach server."))
        }
    }
}