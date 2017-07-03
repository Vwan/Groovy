package vw

import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Created by wanjia on 4/5/2017.
 */
class ZipUnzipUtils_New {
    def fileCopy = {File ins, File out->
        def bi = new BufferedInputStream(ins.newDataInputStream())
        def bufferSize=512
        new BufferedOutputStream(out,bufferSize).withWriter("UTF-8"){writer->
            writer.write(bi.read(bufferSize))
        }
    }

    static def unZipFile(input,output) {
        def zipFile = new ZipFile(new File(input))
        zipFile.with{
            entries().each {
                if (it.isDirectory()) {
                    new File(output + it).mkdirs()
                } else {
                    def fileCopy = {File out, ZipEntry entry->
                        def bi = new BufferedInputStream(zipFile.getInputStream(entry))
                        def bo = new FileOutputStream(out)
                        int bufferSize=512
                        new BufferedOutputStream(bo,bufferSize).withWriter("UTF-8"){writer->
                            writer.write(bi.read())
                        }
                }
                    fileCopy(new File(output + it.toString().replaceAll("/", "\\\\")),it)
                }
            }
        }
    }

    static def zipFile(input,output){
        def zipOutput = new ZipOutputStream(new ZipFile(output))
        new File(input).with{
            traverse {
                if(it.isDirectory()){

                }
                else{
                    ZipEntry entry = new ZipEntry(it)
                    zipOutput.putNextEntry(entry)
                }
            }
            eachFile {
                //println it
            }
        }
    }
}
