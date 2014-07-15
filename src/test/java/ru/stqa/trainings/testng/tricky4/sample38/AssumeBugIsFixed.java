package ru.stqa.trainings.testng.tricky4.sample38;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;

public class AssumeBugIsFixed implements IAnnotationTransformer {

  @Override
  public void transform(ITestAnnotation annotation, Class testClass,
      Constructor testConstructor, Method testMethod) {
    Bug bugAnnotation = testMethod.getAnnotation(Bug.class);
    if (bugAnnotation != null) {
      try {
        MantisConnectLocator mcl = new MantisConnectLocator();
        MantisConnectPortType mcp = mcl.getMantisConnectPort(
            new URL("http://localhost/mantisbt-1.2.17/api/soap/mantisconnect.php"));
        IssueData issue = mcp.mc_issue_get("administrator", "root",
            BigInteger.valueOf(bugAnnotation.value()));
        String status = issue.getStatus().getName();
        if (! ("closed".equals(status) || "resolved".equals(status))) {
          annotation.setEnabled(false);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}
