package me.zohar.lottery.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.betting.param.BettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.LowerLevelBettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.PlaceOrderParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface BettingApi {

	@GetMapping("/betting/findTop50WinningRank")
	Result findTop50WinningRank();

	@GetMapping("/betting/findMyOrLowerLevelBettingOrderDetails")
	Result findMyOrLowerLevelBettingOrderDetails(@RequestParam(value = "id") String id);

	@PostMapping("/betting/findMyBettingOrderInfoByPage")
	Result findMyBettingOrderInfoByPage(@RequestBody BettingOrderQueryCondParam param);

	@GetMapping("/betting/findTodayLatestThe5TimeBettingRecord")
	Result findTodayLatestThe5TimeBettingRecord(@RequestParam(value = "gameCode") String gameCode);

	@PostMapping("/betting/placeOrder")
	Result placeOrder(@RequestBody PlaceOrderParam placeOrderParam);

	@GetMapping("/betting/cancelOrder")
	Result cancelOrder(@RequestParam(value = "orderId") String orderId);

	@GetMapping("/betting/batchCancelOrder")
	Result batchCancelOrder(@RequestBody List<String> orderIds);

	@PostMapping("/betting/findLowerLevelBettingOrderInfoByPage")
	Result findLowerLevelBettingOrderInfoByPage(@RequestBody LowerLevelBettingOrderQueryCondParam param);

}
