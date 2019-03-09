package com.thornchg.rkt.utils;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import java.util.List;

public class XmlUtils {
    private static DocumentFactory factory;
    static {
        factory=DocumentFactory.getInstance();
    }
    public static String listToXml(List<String> stringList){
        Element items = factory.createElement("items");
        for (String s : stringList) {
            Element item = factory.createElement("item");
            item.addText(s);
            items.add(item);
        }
        return items.asXML();
    }
}
