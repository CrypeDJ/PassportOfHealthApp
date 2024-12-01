package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.LifestyleModel
import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.domain.repository.LifecycleRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class LifecycleRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
):LifecycleRepository {
    private val user = firebaseAuth.currentUser ?: throw Exception("User not authenticated")
    private val collection = firestore.collection("lifestyle")
        .document(user.uid)

    override suspend fun saveLifestyle(lifestyle: LifestyleModel): Result<Unit> {
        return try {
            collection.set(lifestyle).await()
            Result.success(Unit)
        } catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun getLifestyle(): LifestyleModel {
        return try {
            collection.get().await().toObject<LifestyleModel>() ?: LifestyleModel()
        } catch (e:Exception){
            LifestyleModel()
        }
    }

}