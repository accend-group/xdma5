package com.companyname.myapp.selenium.Server;



import org.seleniumhq.jetty9.server.Server;

public class AppServer {
        private Server server = new Server();

        public AppServer() throws Exception {
           /* WebAppContext context = new WebAppContext();
            context.setContextPath("");
            context.setWar(new File("."));
            server.addHandler(context);

            context.addServlet(DriverServlet.class, "/wd/*");

            SelectChannelConnector connector = new SelectChannelConnector();
            connector.setPort(3001);
            server.addConnector(connector);

            server.start();
        }*/
    }
}
