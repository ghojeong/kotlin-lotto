package lotto.view

import lotto.dto.LottosDto
import lotto.dto.ResultDto

object OutputView {

    fun printLottos(lottosDto: LottosDto) {
        println("\n수동으로 ${lottosDto.manualSize}장, ${lottosDto.autoSize}으로 11개를 구매했습니다.")
        lottosDto.lottos.forEach { println(it.numbers) }
    }

    fun printResult(resultDto: ResultDto) {
        println("\n당첨 통계\n---------")
        print(resultDto.result)
        println("총 수익률은 ${String.format("%.2f", resultDto.ratio)}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
