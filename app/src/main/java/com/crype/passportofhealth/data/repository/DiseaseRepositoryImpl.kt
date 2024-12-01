package com.crype.passportofhealth.data.repository

import com.crype.passportofhealth.domain.model.DiseaseModel
import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.domain.repository.DiseaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DiseaseRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
): DiseaseRepository {
    private val user = firebaseAuth.currentUser ?: throw Exception("User not authenticated")
    private val collection = firestore.collection("users")
        .document(user.uid).collection("diseases")

    override suspend fun getDiseases(): List<DiseaseModel> {
        return try {
            val snapshot = collection.get().await()
            val diseases = snapshot.documents.mapNotNull { doc ->
                doc.toObject(DiseaseModel::class.java)
            }
            diseases
        } catch (e: Exception) {
            return emptyList()
        }
    }

    override suspend fun addDisease(disease: DiseaseModel):Result<Unit> {
        return try {
            val docRef = collection.document()
            docRef.set(disease).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateDisease(index: Int, disease: DiseaseModel):Result<Unit> {
        return try {
            val documents = collection.get().await().documents
            if (index in documents.indices) {
                val docId = documents[index].id
                collection.document(docId).set(disease).await()
                Result.success(Unit)
            } else {
                Result.failure(IndexOutOfBoundsException("Invalid index"))
            }
        } catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun deleteDisease(index: Int):Result<Unit> {
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