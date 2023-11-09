package ch.bfh.cas.mad.mirjam.bmirechner

import androidx.lifecycle.ViewModel

class ResultViewModel (
    private val bmiInterpretationsRepository: BmiInterpretationsRepository
): ViewModel() {
    suspend fun getBmiInterpretations(): List<String> {
        return bmiInterpretationsRepository.all()
    }
}