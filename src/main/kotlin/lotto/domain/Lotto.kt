package lotto.domain

import lotto.exception.IllegalLottoException

@JvmInline
value class Lotto(val numbers: List<LottoNumber>) {
    init {
        if (numbers.size != SIZE) {
            throw IllegalLottoException()
        }
        if (numbers.distinct().size != numbers.size) {
            throw IllegalLottoException("로또의 번호가 중복되어서는 안됩니다.")
        }
    }

    fun checkMatch(winningLotto: Lotto, bonus: LottoNumber): Match {
        return Match.valueOf(winningLotto.count(numbers), numbers.contains(bonus))
    }

    private fun count(lottoNumbers: List<LottoNumber>): Int {
        return lottoNumbers.count { numbers.contains(it) }
    }

    companion object {
        const val SIZE = 6
        const val PRICE = 1000
        fun from(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
