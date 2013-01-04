package org.camunda.bpm.engine.rest;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.activiti.engine.ProcessEngine;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.camunda.bpm.engine.rest.impl.ProcessDefinitionServiceImpl;
import org.camunda.bpm.engine.rest.spi.ProcessEngineProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class AbstractRestServiceTest {
  
  private static final int PORT = 8080;
  protected static final String SERVER_ADDRESS = "http://localhost:" + PORT;
  
  protected static ProcessEngine processEngine;
  protected static Server server;
  
  @BeforeClass
  public static void initialize() {
    
    loadProcessEngineService();
    setupServer();
  }
  
  @AfterClass
  public static void tearDown() {
    server.stop();
    server.destroy();
  }

  private static void setupServer() {
    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(ProcessDefinitionServiceImpl.class);
    sf.setProvider(JSONProvider.class);
    sf.setAddress(SERVER_ADDRESS);
    server = sf.create();
    
  }

  private static void loadProcessEngineService() {
    ServiceLoader<ProcessEngineProvider> serviceLoader = ServiceLoader.load(ProcessEngineProvider.class);
    Iterator<ProcessEngineProvider> iterator = serviceLoader.iterator();
    
    if(iterator.hasNext()) {
      ProcessEngineProvider provider = iterator.next();
      processEngine = provider.getProcessEngine();      
    }
  }

  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class, "test.jar")
        .addPackages(true, "org.camunda.bpm.engine.rest")
        .addAsResource("META-INF/services/org.camunda.bpm.engine.rest.spi.ProcessEngineProvider");
  }
}
