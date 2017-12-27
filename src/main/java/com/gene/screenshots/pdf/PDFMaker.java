package com.gene.screenshots.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


// create a pdf from images. Each image is a single page
public class PDFMaker {

    // save space by storing image paths instead of buffered images
    private LinkedList<String> images = new LinkedList<>();
    private PDDocument pdf;

    public void addImg(String imgFilePath) {
        images.add(imgFilePath);
    }

    public void close() throws IOException {
        if (pdf != null)
            pdf.close();
        images.clear();
    }

    // creates a pdf from the list of images
    // https://stackoverflow.com/questions/22358478/java-create-pdf-pages-from-images-using-pdfbox-library
    private void imagesToPDF() {
        try {
            if (pdf != null)
                pdf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdf = new PDDocument();
        try {
            for (String filePath : images) {
                BufferedImage img = ImageIO.read(new File(filePath));
                PDPage page = new PDPage(new PDRectangle(img.getWidth(), img.getHeight()));
                pdf.addPage(page);
                PDImageXObject pdImage = LosslessFactory.createFromImage(pdf, img);
                PDPageContentStream pageContentStream = new PDPageContentStream(pdf, page);
                pageContentStream.drawImage(pdImage, 0, 0);
                pageContentStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savePDF(String path) {
        try {
            imagesToPDF();
            File newPdf = new File(path);
            pdf.save(newPdf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
