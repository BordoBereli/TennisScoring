package tr.com.kutluoglu.tennisgame

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.StringSpec

/**
 * Created by F.K. on 14.09.2022.
 *
 */

class RunAllTests: StringSpec({
    isolationMode = IsolationMode.InstancePerTest
    include(tennisGameTest())
    include(gameScoreTest())
})