package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
): AuthRepository {
    override suspend fun registerUser(email: String, password: String, name: String): Result<Unit> {
        return try {
            val user = firebaseAuth.createUserWithEmailAndPassword(email, password).await().user
                ?: throw Exception("User creation failed")

            val userData = UserModel(
                surname = "-",
                name = name,
                lastname = "-",
                address = "-",
                workPlace = "-",
                phoneNumber = "-",
                email = email
            )
            firestore.collection("users").document(user.uid).set(userData).await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun loginUser(email: String, password: String): Result<Unit> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}