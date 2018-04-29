package SpringCloud.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${mytest}") // git配置文件里的key
    String mytest;
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return mytest;
    }
}
