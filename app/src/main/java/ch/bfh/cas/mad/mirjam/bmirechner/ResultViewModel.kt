package ch.bfh.cas.mad.mirjam.bmirechner

import androidx.lifecycle.ViewModel

class ResultViewModel (
    private val bmiInterpretationsRepository: BmiInterpretationsRepository
): ViewModel() {
    fun getBmiInterpretations(): List<String> {
        return bmiInterpretationsRepository.all()
    }
}