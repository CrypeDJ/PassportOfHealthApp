package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
):UserRepository {
    private val user = firebaseAuth.currentUser ?: throw Exception("User not authenticated")
    private val collection = firestore.collection("usersInfo")
        .document(user.uid)

    override suspend fun getUser(): UserModel {
        return try {
            collection.get().await().toObject<UserModel>() ?: UserModel()
        } catch (e:Exception){
            UserModel()
        }
    }

    override suspend fun saveUser(user: UserModel): Result<Unit> {
        return try {
            collection.set(user).await()
            Result.success(Unit)
        } catch (e:Exception){
            Result.failure(e)
        }
    }
}