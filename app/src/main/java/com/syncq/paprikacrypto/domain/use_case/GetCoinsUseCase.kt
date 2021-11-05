package com.syncq.paprikacrypto.domain.use_case

import com.syncq.paprikacrypto.common.Resource
import com.syncq.paprikacrypto.data.remote.dto.toCoin
import com.syncq.paprikacrypto.domain.model.Coin
import com.syncq.paprikacrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>("An Unexcpedted"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldnt reach server."))
        }
    }
}