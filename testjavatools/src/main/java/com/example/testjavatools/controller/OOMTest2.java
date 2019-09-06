package com.example.testjavatools.controller;

import java.util.ArrayList;

/**

 * @author LXA

 * 堆溢出

 */
/*报错：

java.lang.OutOfMemoryError: Java heap space*/
//-Xmx512k -Xms512k -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=c:\a
public class OOMTest2 {

    public static void main(String[] args)

    {

        ArrayList list=new ArrayList();

        while(true)

        {

            list.add(new OOMTest2());

        }

    }
}
/*C:\java\jdk1.8.0_74\jdk1.8.0_74\bin\java.exe -Xmx1g -Xms1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=c:\a "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=64657:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\charsets.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\deploy.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\access-bridge-64.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\cldrdata.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\dnsns.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\jaccess.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\jfxrt.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\localedata.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\nashorn.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\sunec.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\sunjce_provider.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\sunmscapi.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\sunpkcs11.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\ext\zipfs.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\javaws.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\jce.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\jfr.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\jfxswt.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\jsse.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\management-agent.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\plugin.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\resources.jar;C:\java\jdk1.8.0_74\jdk1.8.0_74\jre\lib\rt.jar;D:\tensquare_parent\testjavatools\target\classes;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-starter-web\2.1.7.RELEASE\spring-boot-starter-web-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-starter\2.1.7.RELEASE\spring-boot-starter-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot\2.1.7.RELEASE\spring-boot-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-autoconfigure\2.1.7.RELEASE\spring-boot-autoconfigure-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-starter-logging\2.1.7.RELEASE\spring-boot-starter-logging-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;E:\maven_repository\maven_repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;E:\maven_repository\maven_repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.2\log4j-to-slf4j-2.11.2.jar;E:\maven_repository\maven_repository\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;E:\maven_repository\maven_repository\org\slf4j\jul-to-slf4j\1.7.26\jul-to-slf4j-1.7.26.jar;E:\maven_repository\maven_repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;E:\maven_repository\maven_repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-starter-json\2.1.7.RELEASE\spring-boot-starter-json-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\core\jackson-databind\2.9.9\jackson-databind-2.9.9.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\core\jackson-core\2.9.9\jackson-core-2.9.9.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.9\jackson-datatype-jdk8-2.9.9.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.9\jackson-datatype-jsr310-2.9.9.jar;E:\maven_repository\maven_repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.9\jackson-module-parameter-names-2.9.9.jar;E:\maven_repository\maven_repository\org\springframework\boot\spring-boot-starter-tomcat\2.1.7.RELEASE\spring-boot-starter-tomcat-2.1.7.RELEASE.jar;E:\maven_repository\maven_repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.22\tomcat-embed-core-9.0.22.jar;E:\maven_repository\maven_repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.22\tomcat-embed-el-9.0.22.jar;E:\maven_repository\maven_repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.22\tomcat-embed-websocket-9.0.22.jar;E:\maven_repository\maven_repository\org\hibernate\validator\hibernate-validator\6.0.17.Final\hibernate-validator-6.0.17.Final.jar;E:\maven_repository\maven_repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;E:\maven_repository\maven_repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;E:\maven_repository\maven_repository\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;E:\maven_repository\maven_repository\org\springframework\spring-web\5.1.9.RELEASE\spring-web-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-beans\5.1.9.RELEASE\spring-beans-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-webmvc\5.1.9.RELEASE\spring-webmvc-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-aop\5.1.9.RELEASE\spring-aop-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-context\5.1.9.RELEASE\spring-context-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-expression\5.1.9.RELEASE\spring-expression-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\slf4j\slf4j-api\1.7.26\slf4j-api-1.7.26.jar;E:\maven_repository\maven_repository\org\springframework\spring-core\5.1.9.RELEASE\spring-core-5.1.9.RELEASE.jar;E:\maven_repository\maven_repository\org\springframework\spring-jcl\5.1.9.RELEASE\spring-jcl-5.1.9.RELEASE.jar com.example.testjavatools.controller.OOMTest2
java.lang.OutOfMemoryError: Java heap space
Dumping heap to c:\a\java_pid3124.hprof ...
Heap dump file created [1544050765 bytes in 3.532 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at com.example.testjavatools.controller.OOMTest2.main(OOMTest2.java:25)

Process finished with exit code 1*/