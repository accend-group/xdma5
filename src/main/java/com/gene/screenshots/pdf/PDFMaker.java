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
                /*PDPage page = new PDPage(new PDRectangle(img.getWidth(), img.getHeight()));
                pdf.addPage(page);
                PDImageXObject pdImage = LosslessFactory.createFromImage(pdf, img);
                PDPageContentStream pageContentStream = new PDPageContentStream(pdf, page);
                pageContentStream.drawImage(pdImage, 0, 0);
                pageContentStream.close();
                // break the image into pages*/
                int splits = (int) Math.ceil(img.getHeight() / 14000D);
                int left = img.getHeight() % 14000;
                System.out.println(left);
                for (int i = 0; i < splits; ++i) {
                    BufferedImage tempImg = img.getSubimage(0, i == splits - 1 ? img.getHeight() - left : i * 14000, img.getWidth(), i == splits - 1 ? left : 14000);
                    if(i == splits - 1 && left == 0)
                        break;
                    PDPage page = new PDPage(new PDRectangle(tempImg.getWidth(), tempImg.getHeight()));
                    pdf.addPage(page);
                    PDImageXObject pdImage = LosslessFactory.createFromImage(pdf, tempImg);
                    PDPageContentStream pageContentStream = new PDPageContentStream(pdf, page);
                    pageContentStream.drawImage(pdImage, 0, 0);
                    pageContentStream.close();
                }
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
