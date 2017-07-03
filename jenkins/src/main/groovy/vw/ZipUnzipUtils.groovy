package vw

import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Created by wanjia on 4/5/2017.
 */
class ZipUnzipUtils {

    static def unZipFile(input, output) {
        def ins = new File(input)
        def zipFile = new ZipFile(ins)
        zipFile.with {
            entries().each {
                if (it.isDirectory()) {
                    new File(output + it).mkdirs()
                } else {
                    def fileCopy = { File out ->
                        out.newDataOutputStream() << zipFile.getInputStream(it)
                    }
                    fileCopy(new File(output + it.toString().replaceAll("/", "\\\\")))
                }
            }
        }

    }

    static def zipFile(input, output) {
        def zipFile = new ZipOutputStream(new FileOutputStream(output))
            new File(input).with {
                traverse {
                    if (it.isDirectory()) {
                        return
                    } else {
                        zipFile.putNextEntry(new ZipEntry(new File(input).toURI().relativize(it.toURI()).toString()))
                        it.eachByte(1024) { buffer, len ->
                            zipFile.write(buffer, 0, len)
                        }
                        zipFile.closeEntry()
                    }
                }
            }
             zipFile.close()
        }

    static def zipFileAntBuilder(input,output){
        new AntBuilder().zip(destfile: output, basedir: input)
    }

    static def unZipFileAntBuilder(input,output){
        new AntBuilder().unzip(src:input,
                dest:output,
                overwrite:"true" )
    }
}