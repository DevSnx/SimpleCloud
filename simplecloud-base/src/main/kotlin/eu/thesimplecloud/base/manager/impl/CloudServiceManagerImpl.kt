package eu.thesimplecloud.base.manager.impl

import eu.thesimplecloud.api.extension.sendPacketToAllAuthenticatedClients
import eu.thesimplecloud.api.network.packets.service.PacketIORemoveCloudService
import eu.thesimplecloud.api.network.packets.service.PacketIOStopCloudService
import eu.thesimplecloud.api.network.packets.service.PacketIOUpdateCloudService
import eu.thesimplecloud.api.network.packets.service.PacketIOWrapperStartService
import eu.thesimplecloud.api.service.ICloudService
import eu.thesimplecloud.api.service.ServiceState
import eu.thesimplecloud.api.service.impl.AbstractCloudServiceManager
import eu.thesimplecloud.base.manager.startup.Manager
import eu.thesimplecloud.clientserverapi.lib.promise.ICommunicationPromise

class CloudServiceManagerImpl : AbstractCloudServiceManager() {

    override fun updateCloudService(cloudService: ICloudService, fromPacket: Boolean) {
        super.updateCloudService(cloudService, fromPacket)
        Manager.instance.communicationServer.getClientManager().sendPacketToAllAuthenticatedClients(PacketIOUpdateCloudService(cloudService))
    }

    override fun removeCloudService(name: String) {
        super.removeCloudService(name)
        Manager.instance.communicationServer.getClientManager().sendPacketToAllAuthenticatedClients(PacketIORemoveCloudService(name))
    }

    override fun stopService(cloudService: ICloudService): ICommunicationPromise<Unit> {
        val wrapper = cloudService.getWrapper()
        val wrapperClient = Manager.instance.communicationServer.getClientManager().getClientByClientValue(wrapper)
        wrapperClient?.sendUnitQuery(PacketIOStopCloudService(cloudService.getName()))
        return cloudService.closedPromise()
    }

    override fun startService(cloudService: ICloudService): ICommunicationPromise<Unit> {
        if (cloudService.isActive() || cloudService.getState() == ServiceState.CLOSED) throw IllegalStateException("Can not start started service.")
        val wrapper = cloudService.getWrapper()
        val wrapperClient = Manager.instance.communicationServer.getClientManager().getClientByClientValue(wrapper)
        check(wrapperClient != null) { "Can not find client of wrapper to start service ${cloudService.getName()} on." }
        wrapperClient.sendUnitQuery(PacketIOWrapperStartService(cloudService.getName()))
        return cloudService.connectedPromise()
    }
}