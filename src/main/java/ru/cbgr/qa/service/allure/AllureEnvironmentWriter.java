package ru.cbgr.qa.service.allure;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * allure-environment-writer
 * @author automatedowl@yandex.com
 * @version 1.0.0
 * @link <a href="https://github.com/AutomatedOwl/">Github Author</a>
 */
@Slf4j
@SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
public class AllureEnvironmentWriter {

    /**
     * Записывает переменные окружения в отчет allure
     * @param environmentValuesSet - переменные окружения в формате ключ - значение
     */
    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet)  {
        try {
            var docFactory = DocumentBuilderFactory.newInstance();
            var docBuilder = docFactory.newDocumentBuilder();
            var doc = docBuilder.newDocument();
            var environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                var parameter = doc.createElement("parameter");
                var key = doc.createElement("key");
                var value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // Write the content into xml file
            var transformerFactory = TransformerFactory.newInstance();
            var transformer = transformerFactory.newTransformer();
            var source = new DOMSource(doc);
            var allureResultsDir = new File( System.getProperty("user.dir")
                    + "/target/allure-results");
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            var result = new StreamResult(
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
            var docFactory = DocumentBuilderFactory.newInstance();
            var docBuilder = docFactory.newDocumentBuilder();
            var doc = docBuilder.newDocument();
            var environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                var parameter = doc.createElement("parameter");
                var key = doc.createElement("key");
                var value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // write the content into xml file
            var transformerFactory = TransformerFactory.newInstance();
            var transformer = transformerFactory.newTransformer();
            var source = new DOMSource(doc);
            var allureResultsDir = new File(customResultsPath);
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
