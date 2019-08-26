package com.tensquare.friend.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "tensquare-user")
public interface UserClient {
//    调用  tensquare-user 的UserDao中的方法；
    //更新被关注好友粉丝数跟用户自己的关注数
    @PutMapping("/user/{userId}/{friendId}/{num}")
    void updateFansAndFollower(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId,
                               @PathVariable("num") int num);
//  tensquare-user 上没有
    //增加粉丝数
    @RequestMapping(value = "/user/incfans/{userid}/{x}",method = RequestMethod.POST)
    public void incFanscount(@PathVariable("userid")String userid,@PathVariable("x")int x);
// 没有
    //增加关注数
    @RequestMapping(value="/user/incfollow/{userid}/{x}",method= RequestMethod.POST)
    public void incFollowcount(@PathVariable("userid")String userid,@PathVariable("x")int x);
// 测试
    @RequestMapping(value="/user/test/{a}",method= RequestMethod.PUT)
    public Result testTensquareUser(@PathVariable String a);
}
