package io.armory.plugin.manifest

import com.netflix.spinnaker.orca.clouddriver.tasks.manifest.WaitForManifestStableTask
import com.fasterxml.jackson.annotation.JsonProperty
import com.netflix.spinnaker.orca.clouddriver.OortService
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution
import java.util.Optional
import java.util.concurrent.TimeUnit

class OverrideWaitForManifestStableTask(oortService: OortService) : WaitForManifestStableTask(oortService) {
    override fun getDynamicTimeout(stage: StageExecution): Long {
        val timeout = stage.mapTo(ManifestTimeout::class.java)
        return if (timeout.timeoutMinutes.isPresent) {
            TimeUnit.MINUTES.toMillis(timeout.timeoutMinutes.get())
        } else getTimeout()

    }

    private class ManifestTimeout internal constructor(@param:JsonProperty("timeoutMinutes") public val timeoutMinutes: Optional<Long>)
}
