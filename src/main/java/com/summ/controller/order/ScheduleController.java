package com.summ.controller.order;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.request.ScheduleReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.OrderScheduleRes;
import com.summ.model.response.ScheduleRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends AutoMapperController {

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody ScheduleReq scheduleReq,ServletRequest request){
        try {
            scheduleReq.setPage(scheduleReq.getSize() * (scheduleReq.getPage() - 1));
            JAdmin admin = (JAdmin) request.getAttribute("admin");
            scheduleReq.setAdminId(admin.getAdminId());
            Integer orderType = scheduleReq.getOrderType();
            /**合同订单*/
            if (orderType==163){
                List<ScheduleRes> scheduleResList = jOrderScheduleMapper.getContractScheduleList(scheduleReq);
                for (int i=0;i<scheduleResList.size();i++){
                    scheduleResList.get(i).setUnitPrice(scheduleResList.get(i).getScheduleCurrentPrice());

                    //判断日程总价是否为0，是则实时计算出当前总价
                    if (scheduleResList.get(i).getTotalPrice().compareTo(new BigDecimal(0))==0){
                        scheduleResList.get(i).setTotalPrice(scheduleResList.get(i).getScheduleCurrentPrice().multiply(new BigDecimal(String.valueOf((scheduleResList.get(i).getEndTime()-scheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                    }
                    //判断服务师工资是否为0，是则实时计算出服务师当前工资
                    if (scheduleResList.get(i).getCost().compareTo(new BigDecimal(0))==0){
                        scheduleResList.get(i).setCost(new BigDecimal(scheduleResList.get(i).getNannyCurrentPayment()).multiply(new BigDecimal(String.valueOf((scheduleResList.get(i).getEndTime()-scheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                    }
                }
                Map map = ResponseUtil.List2Map(scheduleResList);
                map.put("count",jOrderScheduleMapper.getContractScheduleListCount(scheduleReq));
                return new ModelRes(ModelRes.Status.SUCCESS, "查找合同订单日程 !",map);

            }
            /**临时订单*/
            if (orderType==164){
                List<ScheduleRes> scheduleResList = jOrderScheduleMapper.getAllTempScheduleList(scheduleReq);

                for (ScheduleRes scheduleRes : scheduleResList) {
                    /**判断是不是需要实时计算成本 0则表明需要实时计算*/
                    if (scheduleRes.getCost().compareTo(new BigDecimal(0)) == 0) {
                        /**判断日程是自营还是供应商提供 1为自营*/
                        if (scheduleRes.getSupplierId() == 1) {
                            JNannyInfo jNannyInfo = jNannyInfoMapper.selectById(Long.valueOf(scheduleRes.getNannyId()));
                            JDictInfo jDictInfo = jDictInfoMapper.selectById(Long.valueOf(jNannyInfo.getNannyLevel()));
                            /**根据服务师星级小时工资与日程工作时长计算成本*/
                            scheduleRes.setNannyName(jNannyInfo.getNannyName());
                            scheduleRes.setNannyPhone(jNannyInfo.getNannyPhone());
                            scheduleRes.setCost(new BigDecimal(jDictInfo.getInfo()).multiply(new BigDecimal(String.valueOf((scheduleRes.getEndTime() - scheduleRes.getStartTime()) / 2f))).setScale(2));
                        } else if (scheduleRes.getSupplierId() == -1) {
                            /**此处验证带教工时*/
                            //...
                        }else {
                            JSupplier jSupplier = jSupplierMapper.selectById(Long.valueOf(scheduleRes.getSupplierId()));
                            Map map = new HashMap();
                            map.put("goodsId", scheduleRes.getGoodsId());
                            map.put("supplierId", scheduleRes.getSupplierId());
                            List<JGoodsCost> jGoodsCostList = jGoodsCostMapper.selectByMap(map);
                            /**根据供应商单位成本与订单产品的数量（平方米/个数）计算成本*/
                            scheduleRes.setNannyPhone(jSupplier.getPhone());
                            scheduleRes.setNannyName(jSupplier.getName());
                            scheduleRes.setCost(jGoodsCostList.get(0).getCost().multiply(new BigDecimal(scheduleRes.getServiceAmount())).setScale(2));
                        }
                    }
                }
                Map map = ResponseUtil.List2Map(scheduleResList);
                map.put("count", jOrderScheduleMapper.getAllTempScheduleListCount(scheduleReq));
                return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", map);
            }

            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map<String,List<JOrderSchedule>> list){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update coupon success !",jOrderScheduleMapper.updateBatchById(list.get("list")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
