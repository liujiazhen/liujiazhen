//package org.liujiazhen.poi.test;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.converter.WordToHtmlConverter;
//import org.apache.poi.hwpf.usermodel.Picture;
//import org.w3c.dom.Document;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.*;
//import java.util.List;
//
//
//public class PoiWordToHtml {
//    public static void main(String[] args) throws Exception {
//        final String path = "D:/tmp/poi_test/";
//        final String file = "998.doc";
//        InputStream input = new FileInputStream(path + file);
//        HWPFDocument wordDocument = new HWPFDocument(input);
//        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
//        wordToHtmlConverter.setPicturesManager((content, pictureType, suggestedName, widthInches, heightInches) -> suggestedName);
//        wordToHtmlConverter.processDocument(wordDocument);
//        List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
//        if (pics != null) {
//            for (int i = 0; i < pics.size(); i++) {
//                Picture pic = pics.get(i);
//                pic.writeImageContent(new FileOutputStream(path + pic.suggestFullFileName()));
//            }
//        }
//        Document htmlDocument = wordToHtmlConverter.getDocument();
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        DOMSource domSource = new DOMSource(htmlDocument);
//        StreamResult streamResult = new StreamResult(outStream);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer serializer = tf.newTransformer();
//        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//        serializer.setOutputProperty(OutputKeys.METHOD, "html");
//        serializer.transform(domSource, streamResult);
//        outStream.close();
//        byte[] bytes = outStream.toByteArray();
//        String content = new String(bytes);
//        FileUtils.writeStringToFile(new File(path, "998.html"), content, "utf-8");
//    }
//}
