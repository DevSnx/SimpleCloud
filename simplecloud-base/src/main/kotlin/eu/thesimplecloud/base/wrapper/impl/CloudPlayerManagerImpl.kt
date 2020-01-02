package eu.thesimplecloud.base.wrapper.impl

import eu.thesimplecloud.clientserverapi.lib.promise.ICommunicationPromise
import eu.thesimplecloud.lib.location.ServiceLocation
import eu.thesimplecloud.lib.location.SimpleLocation
import eu.thesimplecloud.lib.player.AbstractCloudPlayerManager
import eu.thesimplecloud.lib.player.ICloudPlayer
import eu.thesimplecloud.lib.player.IOfflineCloudPlayer
import eu.thesimplecloud.lib.player.text.CloudText
import eu.thesimplecloud.lib.service.ICloudService
import java.util.*

class CloudPlayerManagerImpl : AbstractCloudPlayerManager() {

    override fun getCloudPlayer(uniqueId: UUID): ICommunicationPromise<ICloudPlayer> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun getCloudPlayer(name: String): ICommunicationPromise<ICloudPlayer> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun sendMessageToPlayer(cloudPlayer: ICloudPlayer, cloudText: CloudText) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun connectPlayer(cloudPlayer: ICloudPlayer, cloudService: ICloudService): ICommunicationPromise<Unit> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun kickPlayer(cloudPlayer: ICloudPlayer, message: String) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun sendTitle(cloudPlayer: ICloudPlayer, title: String, subTitle: String, fadeIn: Int, stay: Int, fadeOut: Int) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun forcePlayerCommandExecution(cloudPlayer: ICloudPlayer, command: String) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun sendActionbar(cloudPlayer: ICloudPlayer, actionbar: String) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun setUpdates(cloudPlayer: ICloudPlayer, update: Boolean, serviceName: String) {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun teleportPlayer(cloudPlayer: ICloudPlayer, location: SimpleLocation): ICommunicationPromise<Unit> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun hasPermission(cloudPlayer: ICloudPlayer, permission: String): ICommunicationPromise<Boolean> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun getLocationOfPlayer(cloudPlayer: ICloudPlayer): ICommunicationPromise<ServiceLocation> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun sendPlayerToLobby(cloudPlayer: ICloudPlayer): ICommunicationPromise<Unit> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun getOfflineCloudPlayer(name: String): ICommunicationPromise<IOfflineCloudPlayer> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }

    override fun getOfflineCloudPlayer(uniqueId: UUID): ICommunicationPromise<IOfflineCloudPlayer> {
        throw UnsupportedOperationException("Players are not supported in the wrapper")
    }
}