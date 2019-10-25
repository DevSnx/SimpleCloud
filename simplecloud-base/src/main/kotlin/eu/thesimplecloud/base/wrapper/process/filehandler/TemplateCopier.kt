package eu.thesimplecloud.base.wrapper.process.filehandler

import eu.thesimplecloud.lib.CloudLib
import eu.thesimplecloud.lib.directorypaths.DirectoryPaths
import eu.thesimplecloud.lib.service.ICloudService
import eu.thesimplecloud.lib.service.ServiceType
import eu.thesimplecloud.lib.template.ITemplate
import org.apache.commons.io.FileUtils
import java.io.File

class TemplateCopier : ITemplateCopier {

    override fun copyTemplate(cloudService: ICloudService, template: ITemplate) {
        val everyDir = File(DirectoryPaths.paths.templatesPath + "EVERY")
        val everyTypeDir = if (cloudService.getServiceType() == ServiceType.PROXY) File(DirectoryPaths.paths.templatesPath + "EVERY_PROXY") else File(DirectoryPaths.paths.templatesPath + "EVERY_SERVER")
        val templateDirectories = getDirectoriesOfTemplateAndSubTemplates(template)
        val serviceTmpDir = if (cloudService.isStatic()) File(DirectoryPaths.paths.staticPath +  cloudService.getName()) else File(DirectoryPaths.paths.tempPath +  cloudService.getName())
        FileUtils.copyDirectory(everyDir, serviceTmpDir)
        FileUtils.copyDirectory(everyTypeDir, serviceTmpDir)
        templateDirectories.forEach { FileUtils.copyDirectory(it, serviceTmpDir) }
    }

    fun getDirectoriesOfTemplateAndSubTemplates(template: ITemplate): Set<File> {
        val set = HashSet<File>()
        for (templateName in template.getInheritedTemplateNames()){
            val subTemplate = CloudLib.instance.getTemplateManager().getTemplate(templateName)
            subTemplate?.let { set.addAll(getDirectoriesOfTemplateAndSubTemplates(it)) }
        }
        set.add(template.getDirectory())
        return set
    }
}