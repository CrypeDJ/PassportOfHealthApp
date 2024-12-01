package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.domain.repository.VaccinationRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class VaccinationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : VaccinationRepository {
    private val user = firebaseAuth.currentUser ?: throw Exception("User not authenticated")
    private val collection = firestore.collection("users")
        .document(user.uid).collection("vaccinations")

    override suspend fun getVaccinations(): List<VaccinationModel> {
        return try {
            val snapshot = collection.get().await()
            val vaccinations = snapshot.documents.mapNotNull { doc ->
                doc.toObject(VaccinationModel::class.java)
            }
            vaccinations
        } catch (e: Exception) {
            return emptyList()
        }
    }

    override suspend fun addVaccination(vaccination: VaccinationModel): Result<Unit> {
        return try {
            val docRef = collection.document()
            docRef.set(vaccination).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateVaccination(
        index: Int,
        vaccination: VaccinationModel
    ): Result<Unit> {
        return try {
            val documents = collection.get().await().documents
            if (index in documents.indices) {
                val docId = documents[index].id
                collection.document(docId).set(vaccination).await()
                Result.success(Unit)
            } else {
                Result.failure(IndexOutOfBoundsException("Invalid index"))
            }
        } catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun deleteVaccination(index: Int): Result<Unit> {
        return try {
            val documents = collection.get().await().documents
            if (index in documents.indices) {
                val docId = documents[index].id
                collection.document(docId).delete().await()
                Result.success(Unit)
            } else {
                Result.failure(IndexOutOfBoundsException("Invalid index"))
            }
        } catch (e:Exception){
            Result.failure(e)
        }
    }
}