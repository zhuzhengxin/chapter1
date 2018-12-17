 package com.sid.feign;

 import com.sid.demo.entity.User;
 import org.springframework.cloud.openfeign.FeignClient;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;

 import java.util.List;

 /**
 * Created by fangzhipeng on 2017/4/6.
 */
@FeignClient(value = "service-hi",path = "/user")//,fallback = SchedualServiceHiHystric.class)
public interface UserFeign {
    //@RequestMapping(value = "/insert",method = RequestMethod.POST)
    @PostMapping(value = "/insert")
    void insert(User user);
    @GetMapping(value = "/queryById/{id}")
    //@GetMapping(value="/queryById", method = RequestMethod.GET)
    User queryById(@PathVariable("id")Long id);
/*   @GetMapping(value = "/queryAllByLimit")
   List<User> queryAllByLimit( int offset, int limit);*/
    @PostMapping(value = "/queryAll")
    List<User> queryAll(User user);
    @PostMapping(value = "/update")
    int update(User user);
    @GetMapping(value = "/deleteById")
    int deleteById(Long id);


}
