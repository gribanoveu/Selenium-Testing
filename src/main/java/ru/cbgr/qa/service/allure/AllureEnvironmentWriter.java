package ru.cbgr.qa.service.allure;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * allure-environment-writer
 * @author automatedowl@yandex.com
 * @version 1.0.0
 * @link https://github.com/AutomatedOwl/
 */
public class AllureEnvironmentWriter {
    private static final Logger log = LoggerFactory.getLogger(AllureEnvironmentWriter.class);

    /**
     * Записывает переменные окружения в отчет allure
     * @param environmentValuesSet - переменные окружения в формате ключ - значение
     */
    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet)  {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                Element parameter = doc.createElement("parameter");
                Element key = doc.createElement("key");
                Element value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File( System.getProperty("user.dir")
                    + "/target/allure-results");
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File( System.getProperty("user.dir")
                            + "/target/allure-results/environment.xml"));
            transformer.transform(source, result);
            log.info("СОБЫТИЕ: Allure environment data saved");
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }


    /**
     * Записывает переменные окружения в отчет allure
     * @param environmentValuesSet - переменные окружения в формате ключ - значение
     * @param customResultsPath - свой путь до папки allure-results
     */
    public static void allureEnvironmentWriter(
            ImmutableMap<String, String> environmentValuesSet,
            String customResultsPath
    ) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                Element parameter = doc.createElement("parameter");
                Element key = doc.createElement("key");
                Element value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File(customResultsPath);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File( customResultsPath + "environment.xml"));
            transformer.transform(source, result);
            log.info("СОБЫТИЕ: Allure environment data saved");
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
