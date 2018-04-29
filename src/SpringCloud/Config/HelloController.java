package SpringCloud.Config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    private static final Logger logger = Logger  
            .getLogger(HelloController.class.getName());  

    @Value("${mytest}") // git配置文件里的key
    String mytest;
    @Value("${server.port}")
    String port ;
    @Value("${spring.application.name}")
    String name ;

    @RequestMapping(value = "/hi")
    public String hi(){
        return mytest;
    }
    
    @RequestMapping(value = "/say")
    public String say(String message){
    	logger.info("message========="+message);
        return "hi,I am "+name+",my port is :"+port+",your messsage is :"+message;
    }
}
