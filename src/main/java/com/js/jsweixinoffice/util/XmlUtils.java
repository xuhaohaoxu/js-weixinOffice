package com.js.jsweixinoffice.util;
/**
 * @author xuhaooo
 * @date Date : 2021年05月15日 14:19
 * @version V1.0
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 *@description
 *xml解析工具类
 */
public class XmlUtils {

    /**
     * JavaBean转换成xml
     *
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding, boolean format) {
        String result = null;
        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, format);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJava(String xml, Class<T> c) {
        if (xml == null || xml.equals("")){
            return null;
        }

        T t = null;
        StringReader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xml);
            t = (T) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                reader.close();
            }
        }
        return t;
    }
}
