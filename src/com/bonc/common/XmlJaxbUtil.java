package com.bonc.common;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlJaxbUtil {
	/**
	 * 将xml 转换为java bean
	 * @param className
	 * @param xmlStr
	 * @return java bean
	 */
	@SuppressWarnings("unchecked")
	public static <T>T xml2bean(Class<T> clazz,String xmlStr) {
		try {  
            JAXBContext context = JAXBContext.newInstance(clazz); 
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader rd =  new StringReader(xmlStr);   
            T obj = (T)unmarshaller.unmarshal(rd);
			return obj; 
        } catch (JAXBException e) {  
            e.printStackTrace();
            return null;
        } 
	}
	
	/**
	 * 将java bean 转换为xml
	 * @param className
	 * @param bean
	 * @return XmlString
	 * @throws ClassNotFoundException
	 */
	public static String bean2xml(Class<?> clazz,Object bean) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JAXBContext context = JAXBContext.newInstance(clazz);
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); //设置该属性决定是否显示<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			marshaller.marshal(bean, baos);
			
			return baos.toString();
        } catch (JAXBException e) {  
            e.printStackTrace();
            return null;
        } 
	}
}
