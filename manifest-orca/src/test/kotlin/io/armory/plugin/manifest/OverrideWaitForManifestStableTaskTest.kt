package io.armory.plugin.manifest

import dev.minutest.junit.JUnit5Minutests
import dev.minutest.rootContext
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*

class OverrideWaitForManifestStableTaskTest : JUnit5Minutests {

    fun tests() = rootContext {
        test("get dynamic timeout") {
            expectThat(OverrideWaitForManifestStableTask(null)
                    .getDynamicTimeout(OverrideWaitForManifestStableTask.ManifestTimeout(Optional.of(42))))
                    .isEqualTo(2520000)
        }
    }
}
