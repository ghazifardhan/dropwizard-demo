package Application;

import com.apidemo.dropwizarddemo.DatabaseConfiguration;
import com.apidemo.dropwizarddemo.HelloWorldConfiguration;
import com.apidemo.dropwizarddemo.HelloWorldResource;
import com.mysql.fabric.xmlrpc.base.Data;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sun.reflect.annotation.ExceptionProxy;

/**
 * Created by markibid on 10/03/17.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName(){
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){
        // nothing to do yet
    }

    /*
    public void run(DatabaseConfiguration databaseConfiguration, Environment environment) throws Exception {
    }
    */


    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(),
                helloWorldConfiguration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
