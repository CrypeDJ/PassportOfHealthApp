package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.HealthIndicatorsModel
import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.domain.repository.HealthIndicatorRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class HealthIndicatorRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
):HealthIndicatorRepository {
    private val user = firebaseAuth.currentUser ?: throw Exception("User not authenticated")
    private val collection = firestore.collection("healthindicators")
        .document(user.uid)

    override suspend fun saveHealthIndicators(data: HealthIndicatorsModel): Result<Unit> {
        return try {
            collection.set(data).await()
            Result.success(Unit)
        } catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun getHealthIndicators(): HealthIndicatorsModel {
        return try {
            collection.get().await().toObject<HealthIndicatorsModel>() ?: HealthIndicatorsModel()
        } catch (e:Exception){
            HealthIndicatorsModel()
        }
    }
}