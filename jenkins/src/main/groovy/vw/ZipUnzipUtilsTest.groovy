package vw

/**
 * Created by wanjia on 4/5/2017.
 */
class ZipUnzipUtilsTest extends GroovyTestCase{

    // unzip files
    def fileToUnzip="C:\\Users\\wanjia\\Downloads\\apache-groovy-binary-2.4.9.zip"
    def unZipToFolder="c:\\temp\\temp1\\"

    // zip files
    def fileToZip = unZipToFolder+"groovy-2.4.9"
    def zipToFile = unZipToFolder + "groovy-2.4.9.zip"

    void testZipUnzipFiles(){
        ZipUnzipUtils.unZipFile(fileToUnzip,unZipToFolder)
        ZipUnzipUtils.zipFile(fileToZip,zipToFile)
    }

    void  testUnzipFile(){
        ZipUnzipUtils.unZipFile(fileToUnzip,unZipToFolder)
    }

    void  testZipFile(){
        ZipUnzipUtils.zipFile(fileToZip,zipToFile)
    }

    void testZipFileAntBuilder(){
        ZipUnzipUtils.zipFileAntBuilder(fileToZip,zipToFile)
    }

    void testUnZipFileAntBuilder(){
        ZipUnzipUtils.unZipFileAntBuilder(fileToZip,zipToFile)
    }
}
