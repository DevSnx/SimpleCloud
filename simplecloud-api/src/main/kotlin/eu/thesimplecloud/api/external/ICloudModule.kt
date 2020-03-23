package eu.thesimplecloud.api.external

interface ICloudModule {

    /**
     * Called when the plugin is enabled
     */
    fun onEnable()

    /**
     * Called when the plugin is disabled
     */
    fun onDisable()

    /**
     * Returns whether this module is reloadable
     */
    fun isReloadable() = true

}