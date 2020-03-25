package io.armory.plugin.manifest

import com.netflix.spinnaker.kork.plugins.api.spring.PrivilegedSpringPlugin
import org.slf4j.LoggerFactory
import org.pf4j.PluginWrapper
import org.springframework.beans.factory.support.BeanDefinitionRegistry

class WaitForStableManifestPlugin(wrapper: PluginWrapper) : PrivilegedSpringPlugin(wrapper) {

    override fun registerBeanDefinitions(registry: BeanDefinitionRegistry) {
        listOf(
                primaryBeanDefinitionFor(OverrideWaitForManifestStableTask::class.java)
        ).forEach {
            registerBean(it, registry)
        }
    }

    private val logger = LoggerFactory.getLogger(WaitForStableManifestPlugin::class.java)

    override fun start() {
        logger.info("WaitForStableManifestPlugin.start()")
    }

    override fun stop() {
        logger.info("WaitForStableManifestPlugin.stop()")
    }
}
