package com.lwptest.basic.design.vistor;

import java.util.ArrayList;
import java.util.List;

abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }
}

class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    } //...

} //...PPTFile、WordFile代码省略...

class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    } //...

}

class WordFile extends ResourceFile {
    public WordFile(String filePath) {
        super(filePath);
    } //...
    public void accept(){

    }
}

class Extractor {
    public void extract2txt(PPTFile pptFile) { //...

        System.out.println("Extract PPT.");
    }

    public void extract2txt(PdfFile pdfFile) { //...

        System.out.println("Extract PDF.");
    }

    public void extract2txt(WordFile wordFile) { //...

        System.out.println("Extract WORD.");
    }

}

class ToolApplication {

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : resourceFiles) {
            //extractor.extract2txt(resourceFile);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>(); //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;

    }
}

